/*
 * SonarQube Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.java.api.semantic;

import javax.annotation.CheckForNull;
import java.util.List;

/**
 * Holds the metadata information of a symbol.
 * Mainly annotation.
 */
public interface SymbolMetadata {

  boolean isAnnotatedWith(String fullyQualifiedName);

  /**
   * Get the annotation values for the specified annotation.
   * @param fullyQualifiedNameOfAnnotation fully Qualified Name of the annotation
   * @return null if the annotation is not present, a List otherwise
   */
  @CheckForNull
  List<AnnotationValue> valuesForAnnotation(String fullyQualifiedNameOfAnnotation);

  List<AnnotationInstance> annotations();

  /**
   * Occurence of an annotation on a symbol.
   */
  interface AnnotationInstance {

    /**
     * Type symbol of this annotation. Can be unknown if bytecode for this annotation is not provided.
     * @return the symbol declarting this annotation.
     */
    Symbol symbol();

    /**
     * Annotation values for this annotation.
     * @return immutable list of annotation values.
     */
    List<AnnotationValue> values();

  }


  /**
   * Value of a property of an annotation.
   */
  interface AnnotationValue {

    /**
     * Name of the annotation property.
     * @return the name of the property.
     */
    String name();

    /**
     * Stored value of the annotation property.
     */
    Object value();

  }


}
