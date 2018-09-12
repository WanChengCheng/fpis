import org.scalatest.{Matchers, WordSpecLike}
import exercises._

class Ch2 extends WordSpecLike with Matchers {
  "Chapter 2" when {
    "def fib(n: Int): Int" should {
      "return the Fibonacci number of the given integer " which {
        "first element is 0" in {
          Ch2.fib(0) shouldBe 0
          Ch2.fibfor(0) shouldBe 0
          Ch2.fibrec(0) shouldBe 0
        }
        "second element is 1" in {
          Ch2.fib(1) shouldBe 1
          Ch2.fibfor(1) shouldBe 1
          Ch2.fibrec(1) shouldBe 1
        }
        "9th element should be 34" in {
          Ch2.fib(9) shouldBe 34
          Ch2.fibfor(9) shouldBe 34
          Ch2.fibrec(9) shouldBe 34
        }
      }
    }
    "isSorted" should {
      "return true with empty Array" in {
        Ch2.isSorted(Array[Int](), (x: Int, y: Int) => x > y) shouldBe true
      }
      "Array(1, 2, 3) is ordered" in {
        Ch2.isSorted[Int](Array[Int](1, 2, 3), (x, y) => x < y) shouldBe true
      }
      "Array(1, 3, 2) is not ordered" in {
        Ch2.isSorted[Int](Array(1, 3, 2), (x, y) => x < y) shouldBe false
      }
    }

    "currying" should {
      "return the same result" which {
        "does not change result of the meaning of the function" in {
          def fn(x: Int, y: Int) = x + y;
          Ch2.curry(fn)(1)(2) shouldBe fn(1, 2)
        }
      }
    }

    "uncurry" should {
      "return the same result" in {
        def fn(x: Int)(y: Int) = x + y;
        Ch2.uncurry(fn)(1, 2) shouldBe fn(1)(2)
      }
    }
    "compose" should {
      "compose f and g" in {
        def f(x: Int): String = x toString;
        def g(s: String): Int = s.length;
        def cfg = Ch2.compose(g, f);
        cfg(1) shouldBe 1
      }
    }
  }
}
