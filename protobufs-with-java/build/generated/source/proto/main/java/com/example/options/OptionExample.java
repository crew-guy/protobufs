// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: option_example.proto

package com.example.options;

public final class OptionExample {
  private OptionExample() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_example_options_OptionMessageTest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_example_options_OptionMessageTest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_example_options_OptionMessageAnother_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_example_options_OptionMessageAnother_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024option_example.proto\022\017example.options\"" +
      "?\n\021OptionMessageTest\022\013\n\003int\030\001 \001(\005\022\014\n\004nam" +
      "e\030\002 \001(\t\022\017\n\007isValid\030\003 \001(\010\"8\n\024OptionMessag" +
      "eAnother\022\017\n\007id_list\030\001 \003(\005\022\017\n\007address\030\002 \001" +
      "(\tB\027\n\023com.example.optionsP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_example_options_OptionMessageTest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_example_options_OptionMessageTest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_example_options_OptionMessageTest_descriptor,
        new java.lang.String[] { "Int", "Name", "IsValid", });
    internal_static_example_options_OptionMessageAnother_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_example_options_OptionMessageAnother_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_example_options_OptionMessageAnother_descriptor,
        new java.lang.String[] { "IdList", "Address", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
