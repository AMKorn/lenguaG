	extern printf
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
fmtOutInt: db "%d",10,0
fmtOutChar: db "%s",10,0
	section .text
	global main
main:
	mov rbp, rsp
	push rbp

	; 	t0 = 0
	mov eax,0
	mov [t0],eax
	; 	t2 = 6
	mov eax,6
	mov [t2],eax
	; 	t1 = t2
	mov eax,[t2]
	mov [t1],eax
	; 	t4 = 99
	mov eax,99
	mov [t4],eax
	; 	t3 = t4
	mov eax,[t4]
	mov [t3],eax
	; 	t6 = 0
	mov eax,0
	mov [t6],eax
	; 	if t6<t1 goto e0
	; 	t7 = 0
	mov eax,0
	mov [t7],eax
	; 	goto e1
	; e0: skip
e0:
	; 	t7 = -1
	mov eax,-1
	mov [t7],eax
	; e1: skip
e1:
	; 	t5 = t7
	mov eax,[t7]
	mov [t5],eax
	; 	t8[0] = 0
	; 	t8[4] = 1
	; 	t8[8] = 2
	; 	t8[12] = 3
	; 	t8[16] = 4
	; 	t9 = 1
	mov eax,1
	mov [t9],eax
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
	mov [t11],eax
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
	mov [t19],eax
	; 	t20 = t18 + t19
	mov eax,[t18]
	mov ebx,[t19]
	add ebx,eax
	mov [t20],ebx
	; 	t21 = t20 * 10
	; 	t22 = 9
	mov eax,9
	mov [t22],eax
	; 	t23 = t21 + t22
	mov eax,[t21]
	mov ebx,[t22]
	add ebx,eax
	mov [t23],ebx
	; 	t24 = t23 * 4
	; 	t25 = t16[t24]
	; 	t17 = t25
	mov eax,[t25]
	mov [t17],eax
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
	; //t27 -> rbp-16
	mov rdi,fmtOutInt
	mov rsi,[rbp-16]
	mov rax, 0
	call printf
	; 	t28 = 0
	; //t28 -> rbp-0
	mov eax,0
	mov [rbp-0],eax
	; 	rtn foo
	; e2: skip
e2:
	; 	goto e4
	; e5: skip
e5:
	; 	pmb partition
	; 	t35 = 0 * t30
	; //t35 -> rbp--28
	; //t30 -> rbp-24
	; 	t36 = t35 + t32
	; //t36 -> rbp--20
	; //t35 -> rbp--28
	; //t32 -> rbp-16
	mov eax,[rbp--28]
	mov ebx,[rbp-16]
	add ebx,eax
	mov [rbp--20],ebx
	; 	t37 = t36 * 4
	; //t37 -> rbp--12
	; //t36 -> rbp--20
	; 	t38 = t29[t37]
	; //t38 -> rbp--4
	; //t29 -> rbp-4
	; //t37 -> rbp--12
	; 	t34 = t38
	; //t34 -> rbp--36
	; //t38 -> rbp--4
	mov eax,[rbp--4]
	mov [rbp--36],eax
	; 	t40 = 1
	; //t40 -> rbp--156
	mov eax,1
	mov [rbp--156],eax
	; 	t41 = t31 - t40
	; //t41 -> rbp--148
	; //t31 -> rbp-20
	; //t40 -> rbp--156
	; 	t39 = t41
	; //t39 -> rbp-0
	; //t41 -> rbp--148
	mov eax,[rbp--148]
	mov [rbp-0],eax
	; 	t42 = t31
	; //t42 -> rbp--64
	; //t31 -> rbp-20
	mov eax,[rbp-20]
	mov [rbp--64],eax
	; e6: skip
e6:
	; 	if t42<t32 goto e7
	; //t42 -> rbp--64
	; //t32 -> rbp-16
	; 	t43 = 0
	; //t43 -> rbp--60
	mov eax,0
	mov [rbp--60],eax
	; 	goto e8
	; e7: skip
e7:
	; 	t43 = -1
	; //t43 -> rbp--60
	mov eax,-1
	mov [rbp--60],eax
	; e8: skip
e8:
	; 	if t43=0 goto e9
	; //t43 -> rbp--60
	; 	t44 = 0 * t30
	; //t44 -> rbp--136
	; //t30 -> rbp-24
	; 	t45 = t44 + t42
	; //t45 -> rbp--132
	; //t44 -> rbp--136
	; //t42 -> rbp--64
	mov eax,[rbp--136]
	mov ebx,[rbp--64]
	add ebx,eax
	mov [rbp--132],ebx
	; 	t46 = t45 * 4
	; //t46 -> rbp--128
	; //t45 -> rbp--132
	; 	t47 = t29[t46]
	; //t47 -> rbp--120
	; //t29 -> rbp-4
	; //t46 -> rbp--128
	; 	if t47<=t34 goto e10
	; //t47 -> rbp--120
	; //t34 -> rbp--36
	; 	t48 = 0
	; //t48 -> rbp--112
	mov eax,0
	mov [rbp--112],eax
	; 	goto e11
	; e10: skip
e10:
	; 	t48 = -1
	; //t48 -> rbp--112
	mov eax,-1
	mov [rbp--112],eax
	; e11: skip
e11:
	; 	if t48=0 goto e12
	; //t48 -> rbp--112
	; 	t49 = 1
	; //t49 -> rbp--108
	mov eax,1
	mov [rbp--108],eax
	; 	t50 = t39 + t49
	; //t50 -> rbp--104
	; //t39 -> rbp-0
	; //t49 -> rbp--108
	mov eax,[rbp-0]
	mov ebx,[rbp--108]
	add ebx,eax
	mov [rbp--104],ebx
	; 	t39 = t50
	; //t39 -> rbp-0
	; //t50 -> rbp--104
	mov eax,[rbp--104]
	mov [rbp-0],eax
	; 	t51 = 0 * t30
	; //t51 -> rbp--100
	; //t30 -> rbp-24
	; 	t52 = t51 + t39
	; //t52 -> rbp--96
	; //t51 -> rbp--100
	; //t39 -> rbp-0
	mov eax,[rbp--100]
	mov ebx,[rbp-0]
	add ebx,eax
	mov [rbp--96],ebx
	; 	t53 = t52 * 4
	; //t53 -> rbp--92
	; //t52 -> rbp--96
	; 	t54 = t29[t53]
	; //t54 -> rbp--88
	; //t29 -> rbp-4
	; //t53 -> rbp--92
	; 	t55 = t54
	; //t55 -> rbp--84
	; //t54 -> rbp--88
	mov eax,[rbp--88]
	mov [rbp--84],eax
	; 	t56 = 0 * t30
	; //t56 -> rbp--80
	; //t30 -> rbp-24
	; 	t57 = t56 + t42
	; //t57 -> rbp--76
	; //t56 -> rbp--80
	; //t42 -> rbp--64
	mov eax,[rbp--80]
	mov ebx,[rbp--64]
	add ebx,eax
	mov [rbp--76],ebx
	; 	t58 = t57 * 4
	; //t58 -> rbp--72
	; //t57 -> rbp--76
	; 	t59 = t29[t58]
	; //t59 -> rbp--68
	; //t29 -> rbp-4
	; //t58 -> rbp--72
	; 	t54 = t59
	; //t54 -> rbp--88
	; //t59 -> rbp--68
	mov eax,[rbp--68]
	mov [rbp--88],eax
	; 	t59 = t55
	; //t59 -> rbp--68
	; //t55 -> rbp--84
	mov eax,[rbp--84]
	mov [rbp--68],eax
	; e12: skip
e12:
	; 	t60 = 1
	; //t60 -> rbp--124
	mov eax,1
	mov [rbp--124],eax
	; 	t61 = t42 + t60
	; //t61 -> rbp--116
	; //t42 -> rbp--64
	; //t60 -> rbp--124
	mov eax,[rbp--64]
	mov ebx,[rbp--124]
	add ebx,eax
	mov [rbp--116],ebx
	; 	t42 = t61
	; //t42 -> rbp--64
	; //t61 -> rbp--116
	mov eax,[rbp--116]
	mov [rbp--64],eax
	; 	goto e6
	; e9: skip
e9:
	; 	t62 = 0 * t30
	; //t62 -> rbp--56
	; //t30 -> rbp-24
	; 	t63 = 1
	; //t63 -> rbp--52
	mov eax,1
	mov [rbp--52],eax
	; 	t64 = t39 + t63
	; //t64 -> rbp--48
	; //t39 -> rbp-0
	; //t63 -> rbp--52
	mov eax,[rbp-0]
	mov ebx,[rbp--52]
	add ebx,eax
	mov [rbp--48],ebx
	; 	t65 = t62 + t64
	; //t65 -> rbp--40
	; //t62 -> rbp--56
	; //t64 -> rbp--48
	mov eax,[rbp--56]
	mov ebx,[rbp--48]
	add ebx,eax
	mov [rbp--40],ebx
	; 	t66 = t65 * 4
	; //t66 -> rbp--32
	; //t65 -> rbp--40
	; 	t67 = t29[t66]
	; //t67 -> rbp--24
	; //t29 -> rbp-4
	; //t66 -> rbp--32
	; 	t68 = t67
	; //t68 -> rbp--16
	; //t67 -> rbp--24
	mov eax,[rbp--24]
	mov [rbp--16],eax
	; 	t69 = 0 * t30
	; //t69 -> rbp--8
	; //t30 -> rbp-24
	; 	t70 = t69 + t32
	; //t70 -> rbp--164
	; //t69 -> rbp--8
	; //t32 -> rbp-16
	mov eax,[rbp--8]
	mov ebx,[rbp-16]
	add ebx,eax
	mov [rbp--164],ebx
	; 	t71 = t70 * 4
	; //t71 -> rbp--160
	; //t70 -> rbp--164
	; 	t72 = t29[t71]
	; //t72 -> rbp--152
	; //t29 -> rbp-4
	; //t71 -> rbp--160
	; 	t67 = t72
	; //t67 -> rbp--24
	; //t72 -> rbp--152
	mov eax,[rbp--152]
	mov [rbp--24],eax
	; 	t72 = t68
	; //t72 -> rbp--152
	; //t68 -> rbp--16
	mov eax,[rbp--16]
	mov [rbp--152],eax
	; 	t73 = 1
	; //t73 -> rbp--144
	mov eax,1
	mov [rbp--144],eax
	; 	t74 = t39 + t73
	; //t74 -> rbp--140
	; //t39 -> rbp-0
	; //t73 -> rbp--144
	mov eax,[rbp-0]
	mov ebx,[rbp--144]
	add ebx,eax
	mov [rbp--140],ebx
	; 	t33 = t74
	; //t33 -> rbp--44
	; //t74 -> rbp--140
	mov eax,[rbp--140]
	mov [rbp--44],eax
	; 	rtn partition
	; 	t33 = 0
	; //t33 -> rbp--44
	mov eax,0
	mov [rbp--44],eax
	; 	rtn partition
	; e4: skip
e4:
	; 	goto e13
	; e14: skip
e14:
	; 	pmb quickSort
	; 	if t77<t78 goto e15
	; //t77 -> rbp-24
	; //t78 -> rbp-20
	; 	t80 = 0
	; //t80 -> rbp--24
	mov eax,0
	mov [rbp--24],eax
	; 	goto e16
	; e15: skip
e15:
	; 	t80 = -1
	; //t80 -> rbp--24
	mov eax,-1
	mov [rbp--24],eax
	; e16: skip
e16:
	; 	if t80=0 goto e17
	; //t80 -> rbp--24
	; 	param_c: t75[]
	; //t75 -> rbp-4
	; 	param_s: t77
	; //t77 -> rbp-24
	; 	param_s: t78
	; //t78 -> rbp-20
	; 	call partition
	; 	t81 = t33
	; //t81 -> rbp--20
	; //t33 -> rbp--44
	mov eax,[rbp--44]
	mov [rbp--20],eax
	; 	param_c: t75[]
	; //t75 -> rbp-4
	; 	param_s: t77
	; //t77 -> rbp-24
	; 	t82 = 1
	; //t82 -> rbp--16
	mov eax,1
	mov [rbp--16],eax
	; 	t83 = t81 - t82
	; //t83 -> rbp--12
	; //t81 -> rbp--20
	; //t82 -> rbp--16
	; 	param_s: t83
	; //t83 -> rbp--12
	; 	call quickSort
	; 	param_c: t75[]
	; //t75 -> rbp-4
	; 	t84 = 1
	; //t84 -> rbp--8
	mov eax,1
	mov [rbp--8],eax
	; 	t85 = t81 + t84
	; //t85 -> rbp--4
	; //t81 -> rbp--20
	; //t84 -> rbp--8
	mov eax,[rbp--20]
	mov ebx,[rbp--8]
	add ebx,eax
	mov [rbp--4],ebx
	; 	param_s: t85
	; //t85 -> rbp--4
	; 	param_s: t78
	; //t78 -> rbp-20
	; 	call quickSort
	; e17: skip
e17:
	; 	t79 = 0
	; //t79 -> rbp-0
	mov eax,0
	mov [rbp-0],eax
	; 	rtn quickSort
	; e13: skip
e13:
	; e18: skip
e18:
	; 	pmb main
	; 	t86 = 0 * 2
	; //t86 -> rbp--84
	; 	t87 = 1
	; //t87 -> rbp--80
	mov eax,1
	mov [rbp--80],eax
	; 	t88 = t86 + t87
	; //t88 -> rbp--72
	; //t86 -> rbp--84
	; //t87 -> rbp--80
	mov eax,[rbp--84]
	mov ebx,[rbp--80]
	add ebx,eax
	mov [rbp--72],ebx
	; 	t89 = t88 * 10
	; //t89 -> rbp--64
	; //t88 -> rbp--72
	; 	t90 = 1
	; //t90 -> rbp--76
	mov eax,1
	mov [rbp--76],eax
	; 	t91 = t89 + t90
	; //t91 -> rbp--68
	; //t89 -> rbp--64
	; //t90 -> rbp--76
	mov eax,[rbp--64]
	mov ebx,[rbp--76]
	add ebx,eax
	mov [rbp--68],ebx
	; 	t92 = t91 * 4
	; //t92 -> rbp--60
	; //t91 -> rbp--68
	; 	t93 = t16[t92]
	; //t93 -> rbp--56
	; //t92 -> rbp--60
	; 	param_s: t93
	; //t93 -> rbp--56
	; 	call foo
	; 	t94[0] = 72
	; //t94 -> rbp--52
	; 	t94[1] = 111
	; //t94 -> rbp--52
	; 	t94[2] = 108
	; //t94 -> rbp--52
	; 	t94[3] = 97
	; //t94 -> rbp--52
	; 	out: t94
	; //t94 -> rbp--52
	mov rdi,fmtOutInt
	mov rsi,[rbp--52]
	mov rax, 0
	call printf
	; 	t95[16] = 5
	; //t95 -> rbp--28
	; 	t95[20] = 9
	; //t95 -> rbp--28
	; 	t95[24] = 4
	; //t95 -> rbp--28
	; 	t95[28] = 6
	; //t95 -> rbp--28
	; 	t95[32] = 5
	; //t95 -> rbp--28
	; 	t95[36] = 3
	; //t95 -> rbp--28
	; 	t8 => t95
	; //t95 -> rbp--28
	; 	param_c: t8[]
	; 	param_s: 6
	; 	t96 = 0
	; //t96 -> rbp--24
	mov eax,0
	mov [rbp--24],eax
	; 	param_s: t96
	; //t96 -> rbp--24
	; 	param_s: t1
	; 	call quickSort
	; 	t97[10] = 69
	; //t97 -> rbp--2
	; 	t97[11] = 108
	; //t97 -> rbp--2
	; 	t97[12] = 32
	; //t97 -> rbp--2
	; 	t97[13] = 97
	; //t97 -> rbp--2
	; 	t97[14] = 114
	; //t97 -> rbp--2
	; 	t97[15] = 114
	; //t97 -> rbp--2
	; 	t97[16] = 97
	; //t97 -> rbp--2
	; 	t97[17] = 121
	; //t97 -> rbp--2
	; 	t97[18] = 32
	; //t97 -> rbp--2
	; 	t97[19] = 111
	; //t97 -> rbp--2
	; 	t97[20] = 114
	; //t97 -> rbp--2
	; 	t97[21] = 100
	; //t97 -> rbp--2
	; 	t97[22] = 101
	; //t97 -> rbp--2
	; 	t97[23] = 110
	; //t97 -> rbp--2
	; 	t97[24] = 97
	; //t97 -> rbp--2
	; 	t97[25] = 100
	; //t97 -> rbp--2
	; 	t97[26] = 111
	; //t97 -> rbp--2
	; 	t97[27] = 32
	; //t97 -> rbp--2
	; 	t97[28] = 101
	; //t97 -> rbp--2
	; 	t97[29] = 115
	; //t97 -> rbp--2
	; 	t97[30] = 58
	; //t97 -> rbp--2
	; 	t97[31] = 32
	; //t97 -> rbp--2
	; 	out: t97
	; //t97 -> rbp--2
	mov rdi,fmtOutInt
	mov rsi,[rbp--2]
	mov rax, 0
	call printf
	; 	out: t8
	mov rdi,fmtOutInt
	mov rsi,[t8]
	mov rax, 0
	call printf
	; 	t98[32] = 92
	; //t98 -> rbp-0
	; 	t98[33] = 110
	; //t98 -> rbp-0
	; 	out: t98
	; //t98 -> rbp-0
	mov rdi,fmtOutInt
	mov rsi,[rbp-0]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
