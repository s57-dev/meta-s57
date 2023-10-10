LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ca501bc96ce9ed0814e2c592c3f9593 \
                    file://third_party/fiat/LICENSE;md5=8eb8c1cdeb53faab99e4673182bed9f7 \
                    file://third_party/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third_party/wycheproof_testvectors/LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

SRC_URI = "git://github.com/google/boringssl.git;protocol=https;branch=master"
DEPENDS = "go-native"

PV = "1.0+git${SRCPV}"
SRCREV = "b975f12a2fa3f313b98b0dc40a9bc9e8c0667d08"

S = "${WORKDIR}/git"

inherit cmake perlnative pkgconfig

FILES_${PN} += "${libdir}/libcrypto.so"
FILES_${PN} += "${libdir}/libssl.so"

FILES_${PN}-dev += "${libdir}/cmake/OpenSSL/*"

FILES_${PN}-staticdev += "${libdir}/*.a"

#INHIBIT_SYSROOT_STRIP = "1"
SOLIBS = ".so"

FILES_SOLIBSDEV = ""


EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON"

