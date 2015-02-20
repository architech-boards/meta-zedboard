SUMMARY = "Firmware files for use with TI wl18xx"
SECTION = "devel"

LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://${THISDIR}/files/LICENCE;md5=59f3b63d53b898be68ab7f25363691de"

PACKAGE_ARCH = "all"

SRC_URI = " \
  file://wl18xx-conf.bin \
  file://wl18xx-fw-4.bin \
  file://wl1271-nvs.bin \
"

PV = "R8.5"


#This package doesn't have any files for the rootfs in it, option needed to create an empty 
# package so when the rootfs image is made it finds the mksd_xxx.deb package and doesn't complain
FILES_${PN} = "/lib/firmware/ti-connectivity/*"
ALLOW_EMPTY_${PN} = "1"


# Copy script to the deploy area with u-boot, uImage, and rootfs
do_deploy () {
   install -d ${DEPLOY_DIR_IMAGE}/lib/firmware/ti-connectivity
   install -m 0755 ${WORKDIR}/*.bin ${DEPLOY_DIR_IMAGE}/lib/firmware/ti-connectivity
}

do_install_append () {
   install -d ${D}${base_libdir}/firmware/ti-connectivity
   install -m 0755 ${WORKDIR}/*.bin ${D}${base_libdir}/firmware/ti-connectivity
}

addtask deploy after do_install
