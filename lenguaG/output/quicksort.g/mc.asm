	section .data
t1: 	times 4 db 0
t8: 	times 24 db 0
t5: 	times 4 db 0
t17: 	times 4 db 0
t3: 	times 4 db 0
t16: 	times 80 db 0
t26: 	times 17 db 0
t11: 	times 4 db 0
t25: 	times 4 db 0
t24: 	times 4 db 0
t23: 	times 4 db 0
t22: 	times 4 db 0
t9: 	times 4 db 0
t21: 	times 4 db 0
t20: 	times 4 db 0
t7: 	times 4 db 0
t6: 	times 4 db 0
t4: 	times 1 db 0
t2: 	times 4 db 0
t0: 	times 4 db 0
t19: 	times 4 db 0
t18: 	times 4 db 0
t15: 	times 4 db 0
t14: 	times 4 db 0
t13: 	times 4 db 0
t12: 	times 4 db 0
t10: 	times 4 db 0
	section .text
	global main
main:
	push rbp

	; 	t0 = 0
	mov eax,0
	; 	t2 = 6
	mov eax,6
	; 	t1 = t2
	mov eax,[t2]
	; 	t4 = 99
	mov eax,99
	; 	t3 = t4
	mov eax,[t4]
	; 	t6 = 0
	mov eax,0
	; 	if t6<t1 goto e0
	; 	t7 = 0
	mov eax,0
	; 	goto e1
	; e0: skip
e0:
	; 	t7 = -1
	mov eax,-1
	; e1: skip
e1:
	; 	t5 = t7
	mov eax,[t7]
	; 	t8[0] = 0
	; 	t8[4] = 1
	; 	t8[8] = 2
	; 	t8[12] = 3
	; 	t8[16] = 4
	; 	t9 = 1
	mov eax,1
	; 	t10 = t1 + t9
	mov eax,[t1]
	mov ebx,[t9]
	add ebx,eax
	mov [t10],ebx
	; 	t8[20] = t10
	; 	t12 = 0 * 6
	; 	t13 = t12 + t1
	mov eax,[t12]
	mov ebx,[t1]
	add ebx,eax
	mov [t13],ebx
	; 	t14 = t13 * 4
	; 	t15 = t8[t14]
	; 	t11 = t15
	mov eax,[t15]
	; 	t16[0] = 0
	; 	t16[4] = 1
	; 	t16[8] = 2
	; 	t16[12] = 3
	; 	t16[16] = 4
	; 	t16[20] = 5
	; 	t16[24] = 6
	; 	t16[28] = 7
	; 	t16[32] = 8
	; 	t16[36] = 9
	; 	t16[40] = 10
	; 	t16[44] = 11
	; 	t16[48] = 12
	; 	t16[52] = 13
	; 	t16[56] = 14
	; 	t16[60] = 15
	; 	t16[64] = 16
	; 	t16[68] = 17
	; 	t16[72] = 18
	; 	t16[76] = 19
	; 	t18 = 0 * 2
	; 	t19 = 1
	mov eax,1
	; 	t20 = t18 + t19
	mov eax,[t18]
	mov ebx,[t19]
	add ebx,eax
	mov [t20],ebx
	; 	t21 = t20 * 10
	; 	t22 = 9
	mov eax,9
	; 	t23 = t21 + t22
	mov eax,[t21]
	mov ebx,[t22]
	add ebx,eax
	mov [t23],ebx
	; 	t24 = t23 * 4
	; 	t25 = t16[t24]
	; 	t17 = t25
	mov eax,[t25]
	; 	t26[0] = 69
	; 	t26[1] = 115
	; 	t26[2] = 116
	; 	t26[3] = 111
	; 	t26[4] = 32
	; 	t26[5] = 101
	; 	t26[6] = 115
	; 	t26[7] = 32
	; 	t26[8] = 117
	; 	t26[9] = 110
	; 	t26[10] = 32
	; 	t26[11] = 115
	; 	t26[12] = 116
	; 	t26[13] = 114
	; 	t26[14] = 105
	; 	t26[15] = 110
	; 	t26[16] = 103
	; 	goto e2
	; e3: skip
e3:
	; 	pmb foo
	; 	out: t27
	; 	t28 = 0
	mov eax,0
	; 	rtn foo
	; e2: skip
e2:
	; 	goto e4
	; e5: skip
e5:
	; 	pmb partition
	; 	t35 = 0 * t30
	; 	t36 = t35 + t32
	mov eax,[ebp+28]
	mov ebx,[ebp+52]
	add ebx,eax
	mov [ebp+20],ebx
	; 	t37 = t36 * 4
	; 	t38 = t29[t37]
	; 	t34 = t38
	mov eax,[ebp+4]
	; 	t40 = 1
	mov eax,1
	; 	t41 = t31 - t40
	; 	t39 = t41
	mov eax,[ebp+160]
	; 	t42 = t31
	mov eax,[ebp+56]
	; e6: skip
e6:
	; 	if t42<t32 goto e7
	; 	t43 = 0
	mov eax,0
	; 	goto e8
	; e7: skip
e7:
	; 	t43 = -1
	mov eax,-1
	; e8: skip
e8:
	; 	if t43=0 goto e9
	; 	t44 = 0 * t30
	; 	t45 = t44 + t42
	mov eax,[ebp+148]
	mov ebx,[ebp+76]
	add ebx,eax
	mov [ebp+144],ebx
	; 	t46 = t45 * 4
	; 	t47 = t29[t46]
	; 	if t47<=t34 goto e10
	; 	t48 = 0
	mov eax,0
	; 	goto e11
	; e10: skip
e10:
	; 	t48 = -1
	mov eax,-1
	; e11: skip
e11:
	; 	if t48=0 goto e12
	; 	t49 = 1
	mov eax,1
	; 	t50 = t39 + t49
	mov eax,[ebp+0]
	mov ebx,[ebp+120]
	add ebx,eax
	mov [ebp+116],ebx
	; 	t39 = t50
	mov eax,[ebp+116]
	; 	t51 = 0 * t30
	; 	t52 = t51 + t39
	mov eax,[ebp+112]
	mov ebx,[ebp+0]
	add ebx,eax
	mov [ebp+108],ebx
	; 	t53 = t52 * 4
	; 	t54 = t29[t53]
	; 	t55 = t54
	mov eax,[ebp+100]
	; 	t56 = 0 * t30
	; 	t57 = t56 + t42
	mov eax,[ebp+92]
	mov ebx,[ebp+76]
	add ebx,eax
	mov [ebp+88],ebx
	; 	t58 = t57 * 4
	; 	t59 = t29[t58]
	; 	t54 = t59
	mov eax,[ebp+80]
	; 	t59 = t55
	mov eax,[ebp+96]
	; e12: skip
e12:
	; 	t60 = 1
	mov eax,1
	; 	t61 = t42 + t60
	mov eax,[ebp+76]
	mov ebx,[ebp+136]
	add ebx,eax
	mov [ebp+128],ebx
	; 	t42 = t61
	mov eax,[ebp+128]
	; 	goto e6
	; e9: skip
e9:
	; 	t62 = 0 * t30
	; 	t63 = 1
	mov eax,1
	; 	t64 = t39 + t63
	mov eax,[ebp+0]
	mov ebx,[ebp+60]
	add ebx,eax
	mov [ebp+48],ebx
	; 	t65 = t62 + t64
	mov eax,[ebp+68]
	mov ebx,[ebp+48]
	add ebx,eax
	mov [ebp+40],ebx
	; 	t66 = t65 * 4
	; 	t67 = t29[t66]
	; 	t68 = t67
	mov eax,[ebp+24]
	; 	t69 = 0 * t30
	; 	t70 = t69 + t32
	mov eax,[ebp+8]
	mov ebx,[ebp+52]
	add ebx,eax
	mov [ebp+176],ebx
	; 	t71 = t70 * 4
	; 	t72 = t29[t71]
	; 	t67 = t72
	mov eax,[ebp+164]
	; 	t72 = t68
	mov eax,[ebp+16]
	; 	t73 = 1
	mov eax,1
	; 	t74 = t39 + t73
	mov eax,[ebp+0]
	mov ebx,[ebp+156]
	add ebx,eax
	mov [ebp+152],ebx
	; 	t33 = t74
	mov eax,[ebp+152]
	; 	rtn partition
	; 	t33 = 0
	mov eax,0
	; 	rtn partition
	; e4: skip
e4:
	; 	goto e13
	; e14: skip
e14:
	; 	pmb quickSort
	; 	if t77<t78 goto e15
	; 	t80 = 0
	mov eax,0
	; 	goto e16
	; e15: skip
e15:
	; 	t80 = -1
	mov eax,-1
	; e16: skip
e16:
	; 	if t80=0 goto e17
	; 	param_c: t75[]
	; 	param_s: t77
	; 	param_s: t78
	; 	call partition
	; 	t82 = t33
	mov eax,[ebp+44]
	; 	t81 = t82
	mov eax,[ebp+40]
	; 	param_c: t75[]
	; 	param_s: t77
	; 	t83 = 1
	mov eax,1
	; 	t84 = t81 - t83
	; 	param_s: t84
	; 	call quickSort
	; 	t85 = t79
	mov eax,[ebp+0]
	; 	param_c: t75[]
	; 	t86 = 1
	mov eax,1
	; 	t87 = t81 + t86
	mov eax,[ebp+44]
	mov ebx,[ebp+24]
	add ebx,eax
	mov [ebp+20],ebx
	; 	param_s: t87
	; 	param_s: t78
	; 	call quickSort
	; 	t88 = t79
	mov eax,[ebp+0]
	; e17: skip
e17:
	; 	t79 = 0
	mov eax,0
	; 	rtn quickSort
	; e13: skip
e13:
	; e18: skip
e18:
	; 	pmb main
	; 	t89[0] = 5
	; 	t89[4] = 9
	; 	t89[8] = 4
	; 	t89[12] = 6
	; 	t89[16] = 5
	; 	t89[20] = 3
	; 	t8 => t89

	pop rbp
	mov rax,0
ret
