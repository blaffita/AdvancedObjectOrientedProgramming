package noapplet.Record;

public final class Place {
    private final int x;
    private final int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Place place = (Place) obj;

        if (x != place.x) return false;
        return y == place.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Place[x=" + x + ", y=" + y + "]";
    }
    public static void main(String[] args){
        Place p = new Place(10, 20);
        System.out.println(p.x() + ", " + p.y());
        System.out.println(p.equals(new Place(10,20)));
        System.out.println(p.hashCode());
        System.out.println(p);
    }
}
