public class NoteClass {
    private String manufacturer; // производитель
    private String size;
    private String operating;  // операционная система
    private Integer ram; // оперативная память
    private String hddSize; // размер жесткого диска
    private String color;

    public NoteClass(String manufacturer, String size, String operating, Integer ram, String hddSize, String color){
        this.manufacturer = manufacturer;
        this.size = size;
        this.operating = operating;
        this.ram = ram;
        this.hddSize = hddSize;
        this.color = color;
    }

    @Override
    public String toString()
    {
        return String.format(new StringBuilder().append("\tПроизводитель: %s\n")
            .append("\tДиагональ: %s\"\n")
            .append("\tОперационная система: %s\n")
            .append("\tОперативная память: %d Gb\n")
            .append("\tОбъем жесткого диска: %s\n")
            .append("\tЦвет: %s\n").toString(), manufacturer, size, operating, ram, hddSize, color);
    }

    public boolean containsManufacturer(String value) {
        if (NoteClass.this.manufacturer.toLowerCase().contains(value.toLowerCase())) return true;
        else return false;
    }

    public boolean containSize(String value) {
        if (NoteClass.this.size.contains(value)) return true;
        else return false;
    }

    public boolean containsOperation(String value) {
        if (NoteClass.this.operating.toLowerCase().contains(value.toLowerCase())) return true;
        else return false;
    }

    public boolean containsRam(Integer value) {
        if (NoteClass.this.ram == value) return true;
        else return false;
    }

    public boolean containsHdd(String value) {
        if (NoteClass.this.hddSize.toLowerCase().contains(value.toLowerCase())) return true;
        else return false;
    }

    public boolean containsColor(String value) {
        if (NoteClass.this.color.toLowerCase().contains(value.toLowerCase())) return true;
        else return false;
    }

}
