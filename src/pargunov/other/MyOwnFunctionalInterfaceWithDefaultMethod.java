package pargunov.other;

public class MyOwnFunctionalInterfaceWithDefaultMethod {

    public static void main(String[] args) {
        MyFunction<String, Integer> parse = Integer::parseInt;
        MyFunction<String, Integer> squared = parse.andThen(x -> x * x);
        int res = squared.apply("4");
        System.out.println(res);
    }

    interface MyFunction<T, R> {
        R apply(T element);
        // afterFunction.apply(apply(x)); - тут как буд-то мы вызываем метод apply у анонимного класса который
        // реализовал данный метод, т.е. мы распарсили строку, и вернули результат второму методу,
        // который мы реализовали лямбдой
        default <U> MyFunction<T, U> andThen(MyFunction<R, U> afterFunction) {
            return x -> afterFunction.apply(apply(x));
        }
    }
}
