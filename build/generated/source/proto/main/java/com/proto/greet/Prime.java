// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: prime/prime.proto

package com.proto.greet;

public final class Prime {
  private Prime() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_PrimeNumberRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_PrimeNumberRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_greet_PrimeNumberMultipleResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_greet_PrimeNumberMultipleResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021prime/prime.proto\022\005greet\"$\n\022PrimeNumbe" +
      "rRequest\022\016\n\006number\030\001 \001(\005\"-\n\033PrimeNumberM" +
      "ultipleResponse\022\016\n\006number\030\001 \001(\0052l\n\013Prime" +
      "Number\022]\n\030primeNumberDecomposition\022\031.gre" +
      "et.PrimeNumberRequest\032\".greet.PrimeNumbe" +
      "rMultipleResponse\"\0000\001B\023\n\017com.proto.greet" +
      "P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_greet_PrimeNumberRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_greet_PrimeNumberRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_PrimeNumberRequest_descriptor,
        new java.lang.String[] { "Number", });
    internal_static_greet_PrimeNumberMultipleResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_greet_PrimeNumberMultipleResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_greet_PrimeNumberMultipleResponse_descriptor,
        new java.lang.String[] { "Number", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}