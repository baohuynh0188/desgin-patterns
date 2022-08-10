package soliddesginprinciples;

import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED,
    GREEN,
    BLUE
}

enum Size {
    SMALL,
    MEDIUM,
    LARGE
}

class Product {
    private String name;
    private Color color;
    private Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products,
                                         Color color) {
        return products.stream().filter(p -> p.getColor() == color);
    }

    public Stream<Product> filterBySize(List<Product> products,
                                        Size size) {
        return products.stream().filter(p -> p.getSize() == size);
    }

    public Stream<Product> filterByColorAndSize(List<Product> products,
                                                Size size,
                                                Color color) {
        return products.stream().filter(p -> p.getColor() == color && p.getSize() == size);
    }
}

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class BetterFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}

class ColorSpecification implements Specification<Product> {
    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getColor() == this.color;
    }
}

class SizeSpecification implements Specification<Product> {
    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getSize() == this.size;
    }
}

class AndSpecification<T> implements Specification<T> {
    private Specification<T> first;
    private Specification<T> second;

    public AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

public class OCP {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.RED, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.MEDIUM);
        Product dog = new Product("Dog", Color.BLUE, Size.MEDIUM);

        List<Product> products = List.of(apple, tree, house, dog);

        ProductFilter productFilter = new ProductFilter();

        System.out.println("Green product (old):");
        productFilter.filterByColor(products, Color.BLUE)
                .forEach(p -> System.out.println(p.getName() + " " + p.getColor() + " " + p.getSize()));

        BetterFilter betterFilter = new BetterFilter();
        System.out.println("Green product (new):");
        betterFilter.filter(products, new ColorSpecification(Color.BLUE))
                .forEach(p -> System.out.println(p.getName() + " " + p.getColor() + " " + p.getSize()));

        betterFilter.filter(products, new SizeSpecification(Size.LARGE))
                .forEach(p -> System.out.println(p.getName() + " " + p.getColor() + " " + p.getSize()));

        System.out.println("=====");
        betterFilter.filter(products,
                new AndSpecification<>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.MEDIUM)))
                .forEach(p -> System.out.println(p.getName() + " " + p.getColor() + " " + p.getSize()));
    }
}
