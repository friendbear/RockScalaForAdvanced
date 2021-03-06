package basics

import scala.util.Try

/**
  * A Taste of Advanced Scala
  *
  * - Dark Syntax Sugar : The Scala Basics
  */
object DarkSugars extends App {

  def singleArgMethod(arg: Int): String = s"$arg little ducks..."

  val description = singleArgMethod {
    42
  }

  val aTryInstance = Try {  // java's try {...}
    throw new RuntimeException
  }

  List(1,2,3).map { x =>
    x + 1
  }

  // syntax sugar #2:
  // single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }
  // => magic
  val aFunkyInstance: Action = (x: Int) => x + 1

  //example: Runnable
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("Hello, Scala")

  })
  val aSweeterThread = new Thread(() => println("sweet, Scala!"))



  abstract class AnAbstractType {
    def implemented: Int = 23
    def f(a: Int): Unit
  }
  val anAbstractInstance2: AnAbstractType = new AnAbstractType {
    override def f(a: Int): Unit = println("sweet")
  }  // =>
  val anAbstractInstance: AnAbstractType = (a: Int) => println("sweet")


  // syntax sugar #3:
  // the :: and #:: methods are special
  val prependedList = 2 :: List(3, 4)
  // 2.::(List(3,4))
  // List(3,4).::(2)

  // scala spec: last char decides associativity of method
  1 :: 2 :: 3 :: List(4, 5)
  List(4,5).::(3).::(2).::(1) // equivalent


  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this //actual implementation here
  }
  val myStream1 = 1 -->: 2 -->: 3 -->: new MyStream[Int]
  val myStream2 =new MyStream[Int].-->:(3).-->:(2).-->:(1)
  println(myStream1)
  println(myStream2)

  // syntax sugar #4:
  // multi-word method naming
  class TeenGirl(name: String) {
    def `and then said`(gossip: String): Unit = println(s"$name said $gossip")
  }
  val lilly = new TeenGirl("Lilly")
  lilly `and then said` "Scala is so sweet!"


  // syntax sugar #5:
  // generics infix types
  /*
  class Composite[A, B]
  val composite: Int Composite String = ???
  val composite2: Int Composite String = ???

  class -->[A, B]
  val towards: Int --> String = ???
  */

  // syntax sugar #6:
  // update() is very special, mach like apply()
  val anArray = Array(1, 2, 3)
  anArray(2) = 7 // rewrite to = update <=> apply
  anArray.update(2, 7)  //remember apply() <=> update()!
  // used in mutable collections

  // syntax sugar #7:
  // setters for mutable containers
  class Mutable {
    private var internalMember: Int = 0 // private for OO encapsulation
    def member = internalMember // "getter"
    def member_=(value: Int): Unit =
        internalMember = value // "setter"
  }

  val aMutableContainer = new Mutable
  aMutableContainer.member = 42 // rewritem as aMutableContainer.
}
