package com.ivanceras.commons.writer;


/**
 *  Interface to represent API needed to facilitate source file generation.
 */
public interface SourceWriter {
  /**
   * Begin emitting a JavaDoc comment.
   */
  void beginJavaDocComment();

  /**
   * End emitting a JavaDoc comment.
   */
  void endJavaDocComment();

  void indent();

  void indentln(String s);

  /**
   * Emit a printf-style string.
   */
  void indentln(String s, Object... args);

  void outdent();

  void print(String s);

  /**
   * Emit a printf-style string.
   */
  void print(String s, Object... args);

  void println();

  void println(String s);

  void lnprint();

  
  /**
   * new line before printing string
   * @param s
   */
  void lnprint(String s);

  void lnTabPrint(String s);

  /**
   * Emit a printf-style string.
   */
  void println(String s, Object... args);

}
