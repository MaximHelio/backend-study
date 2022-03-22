public class Owner extends Person {
    private String address;

    private String city;

    private String telephone;

    private void setAddress(String address){
        this.address = address;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone(){
        return this.telephone;
    }

    public List<Pet> getPets(){
        return this.pets;
    }

    public void addPet(Pet pet){
        if (pet.isNew()){
            getPets().add(pet);
        }
    }

    public Pet getPet(String name) {
        return getPet(name, false)
    }

    public Pet getPet(Integer id){
        for (Pet pet : getPets()){
            if (!pet.isNew()) {
                Integer compId = pet.getId();
                if (compId.equals(id)) {
                    return pet;
                }
            }
        }
        return null;
    }

    public Pet getPet(String name, boolean ignoreNew){
        name = name.toLowerCase()
        for (Pet pet : getPets()){
            if(!ignoreNew || !pet.isNew()){
                String compName = pet.getName();
                compName = compName == null ? "": compName
            }
        }
    }
}