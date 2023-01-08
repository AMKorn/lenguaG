	extern printf
	section .data
t2: 	times 4 db 0
t0: 	times 4 db 0
t5: 	times 4 db 0
t6: 	times 4 db 0
t3: 	times 4 db 0
t1: 	times 4 db 0
t4: 	times 4 db 0
fmtOutInt: db "%d",10,0
fmtOutChar: db "%s",10,0
	section .text
	global main
main:
	mov rbp, rsp
	push rbp

	; 	t1 = 1
	mov eax,1
	mov [t1],eax
	; 	t0 = t1
	mov eax,[t1]
	mov [t0],eax
	; 	t3 = 2
	mov eax,2
	mov [t3],eax
	; 	t2 = t3
	mov eax,[t3]
	mov [t2],eax
	; 	t6 = -1
	mov eax,-1
	mov [t6],eax
	; 	t5 = t6
	mov eax,[t6]
	mov [t5],eax
	; 	goto e0
	jmp e0
	; e1: skip
e1:
	; 	pmb foo
	; 	if t9=0 goto e2
	mov eax,[rsp+32]
	mov ebx,0
	cmp eax,ebx
	je e2
	; 	t11 = t7 + t8
	mov eax,[rsp+16]
	mov ebx,[rsp+24]
	add ebx,eax
	mov [rsp+-8],ebx
	; 	t10 = t11
	mov eax,[rsp+-8]
	mov [rsp+-12],eax
	; 	rtn foo: t10
	mov eax,[rsp+-12]
	mov [rsp+8],eax
	jmp e3
	; e2: skip
e2:
	; 	t12 = t7 + t8
	mov eax,[rsp+16]
	mov ebx,[rsp+24]
	add ebx,eax
	mov [rsp+-4],ebx
	; 	t12 = -t12
	mov eax,[rsp+-4]
	neg eax
	mov [rsp+-4],eax
	; 	rtn foo: t12
	mov eax,[rsp+-4]
	mov [rsp+8],eax
	jmp e3
	; e3: skip
e3:
	ret
	; e0: skip
e0:
	; e4: skip
e4:
	; 	pmb main
	; 	param_s: t5
	xor rax,rax
	mov eax,[t5]
	push rax
	; 	param_s: t2
	xor rax,rax
	mov eax,[t2]
	push rax
	; 	param_s: t0
	xor rax,rax
	mov eax,[t0]
	push rax
	; 	t13 = call foo
	push rax
	call e1
	pop rbx
	pop rax
	pop rax
	pop rax
	mov [rsp+-4],ebx
	; 	t4 = t13
	mov eax,[rsp+-4]
	mov [t4],eax
	; 	out: t4
	mov rdi,fmtOutInt
	mov rsi,[t4]
	mov rax, 0
	call printf
	; 	t5 = not t5
	mov eax,[t5]
	not eax
	mov [t5],eax
	; 	param_s: t5
	xor rax,rax
	mov eax,[t5]
	push rax
	; 	param_s: t2
	xor rax,rax
	mov eax,[t2]
	push rax
	; 	param_s: t0
	xor rax,rax
	mov eax,[t0]
	push rax
	; 	t14 = call foo
	push rax
	call e1
	pop rbx
	pop rax
	pop rax
	pop rax
	mov [rsp+-8],ebx
	; 	t4 = t14
	mov eax,[rsp+-8]
	mov [t4],eax
	; 	out: t4
	mov rdi,fmtOutInt
	mov rsi,[t4]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
