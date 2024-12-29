public class Main {
    public static void main(String[] args) {
        char startLetter = 'e';
        char endLetter = 'a';

        Text text = new Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras efficitur interdum sem, "
                + "non elementum mauris ullamcorper vel. Suspendisse luctus ipsum eu orci cursus, ac consequat dui "
                + "varius. Ut a iaculis lorem, vitae dignissim dui. Donec commodo, enim vel imperdiet auctor, ante "
                + "nisl bibendum ligula, fermentum efficitur mauris felis a augue. Ut est arcu, fermentum a commodo nec, "
                + "finibus in sapien. Duis placerat enim malesuada blandit ultricies. Integer eu massa id est congue "
                + "efficitur id eu tellus. Morbi consectetur scelerisque aliquet. Mauris feugiat tortor eu diam imperdiet, "
                + "eu cursus odio dignissim. Phasellus vehicula, nulla vitae semper eleifend, nulla ex convallis lectus, "
                + "sit amet convallis nisl justo ac purus.");

        System.out.println("Початкова форма тексту:");
        System.out.println(text);
        System.out.println("\nУ кожному реченні будуть видалені найбільші підрядки, які починаються літерами '"
                + startLetter + "' та закінчуються літерами '" + endLetter + "'.\n");
        Action.execute(text, startLetter, endLetter);
        System.out.println("Вихідний текст:");
        System.out.println(text);
    }
}