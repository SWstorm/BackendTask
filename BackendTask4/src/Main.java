public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Replacer replacer = new Replacer();
        TransformerOfSimpleDate transformer1 = new TransformerOfSimpleDate();
        TransformerOfDate transformer2 = new TransformerOfDate();

        System.out.println("Задание 4.1:");
        counter.analyzer();

        System.out.println("\nЗадание 4.2:");
        replacer.replace();

        System.out.println("\nЗадание 4.3:");
        transformer1.transformDate();

        System.out.println("\nЗадание 4.4:");
        transformer2.transformDate();

    }
}