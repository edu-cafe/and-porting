LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
	01.mytask.c
	
LOCAL_MODULE := mytask

include $(BUILD_EXECUTABLE)
