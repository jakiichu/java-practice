public class EquilateralTriangle {

    private double sideLength;

    public EquilateralTriangle() {
        this.sideLength = 0.0; // По умолчанию длина стороны равна 0
    }

    public EquilateralTriangle(double sideLength) {
        if (sideLength > 0) {
            this.sideLength = sideLength;
        } else {
            throw new IllegalArgumentException("Длина стороны должна быть положительной.");
        }
    }

    public void setSideLength(double sideLength) {
        if (sideLength > 0) {
            this.sideLength = sideLength;
        } else {
            throw new IllegalArgumentException("Длина стороны должна быть положительной.");
        }
    }

    public double getSideLength() {
        return sideLength;
    }

    public double calculatePerimeter() {
        return 3 * sideLength;
    }

    public double calculateArea() {
        return (Math.sqrt(3) / 4) * Math.pow(sideLength, 2);
    }

    public boolean exists() {
        return sideLength > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EquilateralTriangle that = (EquilateralTriangle) obj;
        return Double.compare(that.sideLength, sideLength) == 0;
    }

    @Override
    public String toString() {
        return "EquilateralTriangle {sideLength=" + sideLength + "}";
    }
}

public class index {
    public static void main(String[] args) {
        EquilateralTriangle triangle1 = new EquilateralTriangle();

        triangle1.setSideLength(5.0);

        EquilateralTriangle triangle2 = new EquilateralTriangle(4.0);

        System.out.println("Triangle 1:");
        System.out.println("Side Length: " + triangle1.getSideLength());
        System.out.println("Perimeter: " + triangle1.calculatePerimeter());
        System.out.println("Area: " + triangle1.calculateArea());
        System.out.println("Does triangle1 exist? " + triangle1.exists());

        System.out.println("\nTriangle 2:");
        System.out.println("Side Length: " + triangle2.getSideLength());
        System.out.println("Perimeter: " + triangle2.calculatePerimeter());
        System.out.println("Area: " + triangle2.calculateArea());
        System.out.println("Does triangle2 exist? " + triangle2.exists());

        System.out.println("\nAre triangle1 and triangle2 equal? " + triangle1.equals(triangle2));

        try {
            EquilateralTriangle invalidTriangle = new EquilateralTriangle(-1.0);
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught exception: " + e.getMessage());
        }
    }
}