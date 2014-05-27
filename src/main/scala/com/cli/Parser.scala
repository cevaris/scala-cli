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


  val ArgFlag  = """--([a-zA-Z\-]+)""".r
  val ArgTuple = """--([a-zA-Z]+)=([a-zA-Z]+)""".r

  def clean(args : Array[String]): Array[String] = {
    for(arg <- args) yield arg.trim
  }

  def parse(args : Array[String]) = {

    def go(arg: String) =  {
      println(s"\nMatching '$arg'")
      arg match {
        case ArgFlag(name) => println(s"Found Flag $name")
        case ArgTuple(name, value) => println(s"Found Tuple $name=>$value")
        case defualt => println(s"Could not parse $defualt")
      }
    }

    args.foreach(go)
  }
  
  def main(args : Array[String]) {

    parse(clean(args))

  }
  
  def listLength[A](list: List[A]) : Int = {
    list match {
      case Nil => 0
      case head :: tail => 1 + listLength(tail)
    }
  }
}
  