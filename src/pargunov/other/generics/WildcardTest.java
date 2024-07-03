package pargunov.other.generics;

public class WildcardTest {
    public static void main(String[] args) {
        GradeBook gb = new GradeBook();
        System.out.println(gb.fromArrayToList("a"));
        System.out.println(gb.fromArrayToList(1));
    }
}

class GradeBook {
    public <T> T fromArrayToList(T a) {
        return a;
    }
}

class Grade {
    public void test() {
        System.out.println("test");
    }
}

class HomeGrade extends Grade {

}

class TestGrade extends Grade {

}