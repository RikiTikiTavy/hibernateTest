package testLinkTable;

public enum TypeOfDirectory {
    NEW(55, "NEW"),
    OLD(24, "OLD");


    int number;
    String name;

    TypeOfDirectory(int number, String name){
        this.number = number;
        this.name = name;
    }
}
