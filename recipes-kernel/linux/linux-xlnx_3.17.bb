# Kernel version and SRCREV correspond to: xlnx_3.17 branch
LINUX_VERSION = "3.17"
KBRANCH ?= "xlnx_3.17"
SRCREV ?= "7b042ef9ea5cc359a22110c75342f8e28c9cdff1"

include linux-xlnx.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-xlnx/3.17:"
SRC_URI_append += " \
		file://defconfig \
		file://0001-Updated-the-TI-Wilink8-driver-to-R8.5.patch \
		file://0002-Patching-kernel-to-adapt-TI-Wilink8-driver.patch \
		file://0003-Fixed-TI-Wilink8-driver-with-kernel-structure.patch \
		"

