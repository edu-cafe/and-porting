LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
	01.hellothread.c

LOCAL_SHARED_LIBRARIES := \
#	libcutils		\
#	libutils		\
#	liblog
	
LOCAL_MODULE := myhellothread

include $(BUILD_EXECUTABLE)