package com.epam.rd.java.basic.practice7.entity;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Candy", propOrder = {
        "name",
        "chocolatetype",
        "energy",
        "ingredients",
        "production"
})
public class Candy {
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Chocolatetype", required = true)
    @XmlSchemaType(name = "string")
    protected Chocolatetype chocolatetype;
    @XmlElement(name = "Energy", required = true)
    protected String energy;
    @XmlElement(name = "Ingredients", required = true)
    protected Ingredients ingredients;
    @XmlElement(name = "Production", required = true)
    protected String production;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEnergy() {
        return energy;
    }
    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public Chocolatetype getChocolatetype() {
        return chocolatetype;
    }
    public void setChocolatetype(Chocolatetype chocolatetype) {
        this.chocolatetype = chocolatetype;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }
    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public String getProduction() {
        return production;
    }
    public void setProduction(String production) {
        this.production = production;
    }
}