#!/usr/bin/env python
# -*- coding: utf-8 -*-
import re
fo = open("", "r")

str=fo.read()

print (str)
jh=str.split(" ")
#print (jh)
n=len(jh)
for counter in range(0,n):
    if (jh[0:0]=="@"):
        print (jh[counter])
