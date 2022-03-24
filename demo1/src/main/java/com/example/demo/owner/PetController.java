package com.example.demo.owner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.acl.Owner;
import java.util.Collection;

//직접 view(jsp, tymeleaf)파일을 내보내야할 때 사용
//rest api 사용사면서 controller 이제 사용x
@Controller
@RequestMapping("/owners/{ownerId}")
class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    //OwnerRepository의 생성 책임x => 결합도 낮춤
    private final org.springframework.example.demo.owner.OwnerRepository owners;

    public PetController(org.springframework.example.demo.owner.OwnerRepository owners) {
        this.owners = owners;
    }

    @ModelAttribute("types")
    public Collection<org.springframework.example.demo.owner.PetType> populatePetTypes() {
        return this.owners.findPetTypes();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") int ownerId) {
        return this.owners.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("pet")
    public void initPetBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new org.springframework.example.demo.owner.PetValidator());
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, ModelMap model) {
        org.springframework.example.demo.owner.Pet pet = new org.springframework.example.demo.owner.Pet();
        owner.addPet(pet);
        model.put("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid org.springframework.example.demo.owner.Pet pet, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.addPet(pet);
        if (result.hasErrors()) {
            model.put("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }
        else {
            this.owners.save(owner);
            return "redirect:/owners/{ownerId}";
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(Owner owner, @PathVariable("petId") int petId, ModelMap model) {
        org.springframework.example.demo.owner.Pet pet = owner.getPet(petId);
        model.put("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid org.springframework.example.demo.owner.Pet pet, BindingResult result, Owner owner, ModelMap model) {
        if (result.hasErrors()) {
            model.put("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }
        else {
            owner.addPet(pet);
            this.owners.save(owner);
            return "redirect:/owners/{ownerId}";
        }
    }

}