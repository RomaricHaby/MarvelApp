#!/usr/bin/env bash
##
# @Description :
# This script decrypt with gpg command line
#
# @Args :
#     - 1 : Password
#     - 2 : Source file
#     - 3 : output file
#
# @Error :
#     - 11 : No password
#     - 12 : No input file found
#     - 13 : No output file found
##

#Test if the first arg not empty
if [ -z "${1}" ]; then
  exit 11
fi

#Test if the second arg not empty
if [ -z "${1}" ]; then
  exit 12
fi

#Test if the third arg not empty
if [ -z "${2}" ]; then
  exit 13
fi

gpg -d --bash --passphrase "${1}" "${2}"> "${3}"