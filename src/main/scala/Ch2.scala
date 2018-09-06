package exercises

import scala.annotation.tailrec

object Ch2 {
  // naive implementation
  def fib(n: Int): Int = {
    n match {
      case 0 => 0;
      case 1 => 1;
      case x => fib(x - 2) + fib(x - 1);
    }
  }

  // for implementation
  def fibfor(n: Int): Int = {
    if (n == 0) {
      0
    } else if (n == 1) {
      1
    } else {
      var a = 0;
      var b = 1;
      var result = 0;
      for (i <- 2 to n) {
        result = a + b;
        a = b;
        b = result;
      }
      result;
    }
  }

  // for tail-recursion
  def fibrec(n: Int): Int = {
    @tailrec
    def loop(x: Int, prev: Int, current: Int): Int = {
      if (x <= 0) {
        prev;
      } else {
        loop(x - 1, current, prev + current);
      }
    }

    loop(n, 0, 1);
  }

  // currify
}
