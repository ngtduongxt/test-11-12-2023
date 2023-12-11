public class DrawAnyShape {
    private final int height;

    public DrawAnyShape(int height) {
        this.height = height;
    }

    public void drawDiamond() {
        drawTopHalf();
        drawBottomHalf();
    }

    private void drawTopHalf() {
        int n = height / 2 + 1;

        for (int i = 1; i <= n; i++) {
            drawSpaces(n - i);
            drawStars(2 * i - 1);
            System.out.println();
        }
    }

    private void drawBottomHalf() {
        int n = height / 2;

        for (int i = n; i >= 1; i--) {
            drawSpaces(n - i + 1);
            drawStars(2 * i - 1);
            System.out.println();
        }
    }

    private static void drawSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private void drawStars(int count) {
        for (int i = 0; i < count; i++) {
            if (i == 0 || i == count - 1) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
    }
}
