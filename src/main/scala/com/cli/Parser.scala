package com.cli

/*
 * Copyright 2012 Damian Helme

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
   */
object Parser {


  val NUMBER  = "([0-9]+)".r
  val ARG_TUPLE  = "--([a-zA-Z]+)=([a-zA-Z0-9]+)".r

  def clean(args : Array[String]): Array[String] = {
    for(arg <- args) yield arg.trim
  }

  def parse(args : Array[String]) = {
    def go(arg: String) =  arg match {
      case NUMBER(arg) => println(s"Found Number $arg")
      case defualt => println(s"Could not parse $defualt")
    }

    args.foreach(go)
  }
  
  def main(args : Array[String]) {

    // clean(args).foreach(println)
    parse(clean(args))


    
    // val myList = List(1,2,3)
    // println("Length of " + myList + " is: " + listLength(myList))
  }
  
  def listLength[A](list: List[A]) : Int = {
    list match {
      case Nil => 0
      case head :: tail => 1 + listLength(tail)
    }
  }
}
  