package ca.ubc.cs.cpsc210.quiz.model;

/**
 * Represents a category of restaurant with name and alias.
 */
public class Category {
    private String name;
    private String alias;

    // Constructor initializes name and alias fields
    public Category(String name, String alias){
        this.name = name;
        this.alias = alias;
    }

    public String getName(){return name;}

    public String getAlias(){return alias;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (!alias.equals(category.alias)) return false;
        if (!name.equals(category.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + alias.hashCode();
        return result;
    }

    // Produces the category's name as a string
    @Override
    public String toString(){
        return name;
    }

}
