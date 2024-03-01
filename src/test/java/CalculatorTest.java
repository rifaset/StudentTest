import org.example.Calculator;
import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS) // agar ngetes nya per class ( default nya per method buat JUnit 5+ )
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // untuk memberikan urutan pada test apabila perclass
public class CalculatorTest {
    public int result = 0;

    @BeforeAll
    public void setUp(){
        System.out.println("Before all setup");
    }

    @BeforeEach
    public void setUpBeforeEach(){
        System.out.println("Before each setup");
    }

    @AfterEach
    public void setUpAfterEach(){
        System.out.println("After each setup");
    }

    @AfterAll
    public void setUpAfterAll(){
        System.out.println("After all setup");
    }

    @Test
    @Order(1) // untuk memberikan urutan pada test apabila perclass
    public void testTambah10(){
        int angka = 10;
        Calculator calculator = new Calculator(result , angka);
        result = calculator.tambah();

        Assertions.assertEquals(10, result, "Hasil dari 0 + 10 adalah 10");
    }

    @Test
    @Order(2)
    public void testKali10(){
        int angka = 10;
        Calculator calculator = new Calculator(result , angka);

        result = calculator.kali();
        Assertions.assertEquals(100, result, "Hasil dari 10 * 10 adalah 100");
    }
}
