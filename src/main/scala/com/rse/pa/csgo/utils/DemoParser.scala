package com.rse.pa.csgo.utils

import sys.process._
/**
 * Created by rotem on 13/11/14.
 */
object DemoParser {
  /**
   * This method receives the path for the demoutil executable, an input folder of demos,
   * and output folder for parsed demos.
   * @param execPath
   * @param execCommands
   * @param demoFilePath
   * @param outputPath
   */
    def runDemoUtil(execPath: String, execCommands: String,
                    demoFilePath : String, outputPath : String): Unit = {


      val outputFile = new java.io.File(outputPath)

      println(outputFile)

      val splitToPathAndName = demoFilePath splitAt (demoFilePath lastIndexOf "/");
      val demPath =  splitToPathAndName._1;
      val demFile = splitToPathAndName._2.drop(1);


      println((demPath +" " + demFile))


      val command = Process(s"${execPath}  ${execCommands} ${demFile}", new java.io.File(demPath)) ;

      println(command)

      val result =  command #> outputFile !


      println(result);
    }
}
