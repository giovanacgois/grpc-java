// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: calculator/calculator.proto

package com.proto.calculator;

public final class CalculatorOuterClass {
  private CalculatorOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_Calculator_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_Calculator_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_CalculatorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_CalculatorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_CalculatorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_CalculatorResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_ComputeAverageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_ComputeAverageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_ComputeAverageResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_ComputeAverageResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_FindMaximumRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_FindMaximumRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_FindMaximumResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_FindMaximumResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_SquareRootRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_SquareRootRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_calculator_SquareRootResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_calculator_SquareRootResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033calculator/calculator.proto\022\ncalculato" +
      "r\"7\n\nCalculator\022\024\n\014first_number\030\001 \001(\003\022\023\n" +
      "\013last_number\030\002 \001(\003\"?\n\021CalculatorRequest\022" +
      "*\n\ncalculator\030\001 \001(\0132\026.calculator.Calcula" +
      "tor\"$\n\022CalculatorResponse\022\016\n\006result\030\001 \001(" +
      "\003\"\'\n\025ComputeAverageRequest\022\016\n\006number\030\001 \001" +
      "(\003\"2\n\026ComputeAverageResponse\022\030\n\020average_" +
      "computed\030\001 \001(\001\"$\n\022FindMaximumRequest\022\016\n\006" +
      "number\030\001 \001(\003\"%\n\023FindMaximumResponse\022\016\n\006m" +
      "aximo\030\001 \001(\003\"#\n\021SquareRootRequest\022\016\n\006numb" +
      "er\030\001 \001(\005\")\n\022SquareRootResponse\022\023\n\013number" +
      "_root\030\001 \001(\0012\334\002\n\021CalculatorService\022K\n\nCal" +
      "culator\022\035.calculator.CalculatorRequest\032\036" +
      ".calculator.CalculatorResponse\022Y\n\016Comput" +
      "eAverage\022!.calculator.ComputeAverageRequ" +
      "est\032\".calculator.ComputeAverageResponse(" +
      "\001\022R\n\013FindMaximum\022\036.calculator.FindMaximu" +
      "mRequest\032\037.calculator.FindMaximumRespons" +
      "e(\0010\001\022K\n\nSquareRoot\022\035.calculator.SquareR" +
      "ootRequest\032\036.calculator.SquareRootRespon" +
      "seB\030\n\024com.proto.calculatorP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_calculator_Calculator_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_calculator_Calculator_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_Calculator_descriptor,
        new java.lang.String[] { "FirstNumber", "LastNumber", });
    internal_static_calculator_CalculatorRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_calculator_CalculatorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_CalculatorRequest_descriptor,
        new java.lang.String[] { "Calculator", });
    internal_static_calculator_CalculatorResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_calculator_CalculatorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_CalculatorResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_calculator_ComputeAverageRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_calculator_ComputeAverageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_ComputeAverageRequest_descriptor,
        new java.lang.String[] { "Number", });
    internal_static_calculator_ComputeAverageResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_calculator_ComputeAverageResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_ComputeAverageResponse_descriptor,
        new java.lang.String[] { "AverageComputed", });
    internal_static_calculator_FindMaximumRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_calculator_FindMaximumRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_FindMaximumRequest_descriptor,
        new java.lang.String[] { "Number", });
    internal_static_calculator_FindMaximumResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_calculator_FindMaximumResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_FindMaximumResponse_descriptor,
        new java.lang.String[] { "Maximo", });
    internal_static_calculator_SquareRootRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_calculator_SquareRootRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_SquareRootRequest_descriptor,
        new java.lang.String[] { "Number", });
    internal_static_calculator_SquareRootResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_calculator_SquareRootResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_calculator_SquareRootResponse_descriptor,
        new java.lang.String[] { "NumberRoot", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}