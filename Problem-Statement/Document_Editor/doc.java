import java.util.*;
abstract class DocumentElement{
    public abstract void render();
}
class TextElement extends DocumentElement{
    private String text;
    public TextElement(String text){
        this.text = text;
    }
    @Override
    public void render(){
        System.out.println("Text : " + text);
    }
}
class ImageElement extends DocumentElement{
    private String imagePath;
    public ImageElement(String imagePath){
        this.imagePath = imagePath;
    }
    @Override
    public void render(){
        System.out.println("Image : " + imagePath);
    }
}
class Document{
    private List<DocumentElement> elements;
    public Document(){
        elements=new ArrayList<>();
    }
    public void addElement(DocumentElement element){
        elements.add(element);
    }
    public void render(){
        System.out.println("\n----- Document -----");
        for (DocumentElement element : elements) {
            element.render();
        }
        System.out.println("--------------------");
    }
}
abstract class Persistence{
    public abstract void save(Document document);
}
class SaveToFile extends Persistence{
    @Override
    public void save(Document document) {
        System.out.println("Document Saved into File.");
    }
}
class SaveToDB extends Persistence {
    @Override
    public void save(Document document) {
        System.out.println("Document Saved into Database.");
    }
}
class DocumentEditor{
    private Document document;
    private Persistence persistence;

    public DocumentEditor(Document document,Persistence persistence){
        this.document = document;
        this.persistence = persistence;
    }
    public void addText(String text){
        document.addElement(new TextElement(text));
    }
    public void addImage(String path){
        document.addElement(new ImageElement(path));
    }
    public void renderDocument(){
        document.render();
    }
    public void save(){
        persistence.save(document);
    }
}
public class Main {
    public static void main(String[] args) {
        Document document=new Document();
        Persistence persistence=new SaveToFile();
        DocumentEditor editor=new DocumentEditor(document, persistence);
        
        editor.addText("Hello Mridul");
        editor.addImage("cat.png");
        editor.addText("Welcome to SOLID Principles");
        editor.renderDocument();
        editor.save();

    }

}
