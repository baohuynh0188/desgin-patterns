package builder;

import java.util.ArrayList;
import java.util.Collections;

class HtmlElement {
    public String name;
    public String text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        String i = String.join("", Collections.nCopies(indent * indentSize, " "));
        stringBuilder.append(String.format("%s<%s>%s", i, name, newLine));
        if (text != null && !text.isEmpty()) {
            stringBuilder.append(String.join("", Collections.nCopies(indentSize * (indent + 1), "")))
                    .append(text)
                    .append(newLine);
        }

        for (HtmlElement e : elements) {
            stringBuilder.append(e.toStringImpl(indent + 1));
        }
        stringBuilder.append(String.format("%s</%s>%s", i, name, newLine));
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}

class HtmlBuilder {
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    public HtmlBuilder addChild(String childName, String childText) {
        HtmlElement htmlElement = new HtmlElement(childName, childText);
        root.elements.add(htmlElement);
        return this;
    }

    public void clear() {
        root = new HtmlElement();
        root.name = rootName;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

public class Demo {
    public static void main(String[] args) {
//        String hello = "Hello";
//        System.out.println("<p>" + hello + "</p>");
//
//        String[] words = {"hello", "world"};
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("<ul>\n");
//        for (String word : words) {
//            stringBuilder.append(String.format("  <li>%s</li>\n", word));
//        }
//        stringBuilder.append("</ul>");
//
//        System.out.println(stringBuilder);
        HtmlBuilder htmlBuilder = new HtmlBuilder("ul");
//        htmlBuilder.addChild("li", "hello");
//        htmlBuilder.addChild("li", "World");
        htmlBuilder.addChild("li", "hello").addChild("li", "World");
        System.out.println(htmlBuilder);
    }
}
