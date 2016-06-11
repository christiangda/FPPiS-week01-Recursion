package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  test("pascal: col=0,row=2") {
    assert(pascal(0, 2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1, 2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1, 3) === 3)
  }

  /** Additional tests*/
  test("pascal: col=0,row=0") {
    assert(pascal(0, 0) === 1)
  }

  test("pascal: col=-1,row=0") {
    assert(pascal(-1, 0) === 0)
  }

  test("pascal: col=0,row=-1") {
    assert(pascal(0, -1) === 1)
  }

  test("pascal: col=-1,row=-1") {
    assert(pascal(-1, -1) === 1)
  }

  test("pascal: col=10,row=-1") {
    assert(pascal(10, -1) === 1)
  }

  test("pascal: col=-1,row=10") {
    assert(pascal(-1, 10) === 0)
  }

  test("pascal: col=123,row=123") {
    assert(pascal(123, 123) === 1)
  }
  test("pascal: col=12,row=21") {
    assert(pascal(12, 21) === 293930)
  }
}
