	extern printf
	section .text
	global main
main:
	mov rbp,rsp
	push rbp

	; 	t0[0] = 1
	mov rax,t0
	xor rbx,rbx
	mov ebx,0
	add rax,rbx
	mov ebx,1
	mov [rax],ebx
	; 	t0[4] = 2
	mov rax,t0
	xor rbx,rbx
	mov ebx,4
	add rax,rbx
	mov ebx,2
	mov [rax],ebx
	; 	t0[8] = 3
	mov rax,t0
	xor rbx,rbx
	mov ebx,8
	add rax,rbx
	mov ebx,3
	mov [rax],ebx
	; 	t0[12] = 4
	mov rax,t0
	xor rbx,rbx
	mov ebx,12
	add rax,rbx
	mov ebx,4
	mov [rax],ebx
	; 	t0[16] = 5
	mov rax,t0
	xor rbx,rbx
	mov ebx,16
	add rax,rbx
	mov ebx,5
	mov [rax],ebx
	; 	t0[20] = 6
	mov rax,t0
	xor rbx,rbx
	mov ebx,20
	add rax,rbx
	mov ebx,6
	mov [rax],ebx
	; 	t0[24] = 7
	mov rax,t0
	xor rbx,rbx
	mov ebx,24
	add rax,rbx
	mov ebx,7
	mov [rax],ebx
	; 	t0[28] = 8
	mov rax,t0
	xor rbx,rbx
	mov ebx,28
	add rax,rbx
	mov ebx,8
	mov [rax],ebx
	; e0: skip
e0:
	; 	pmb main
	; 	t1 = 0 * 2
	mov eax,0
	mov ecx,2
	mul ecx
	mov [rsp+-28],eax
	; 	t2 = 1
	mov eax,1
	mov [rsp+-24],eax
	; 	t3 = t1 + t2
	mov eax,[rsp+-28]
	mov ebx,[rsp+-24]
	add ebx,eax
	mov [rsp+-20],ebx
	; 	t4 = t3 * 4
	mov eax,[rsp+-20]
	mov ecx,4
	mul ecx
	mov [rsp+-16],eax
	; 	t5 = 3
	mov eax,3
	mov [rsp+-12],eax
	; 	t6 = t4 + t5
	mov eax,[rsp+-16]
	mov ebx,[rsp+-12]
	add ebx,eax
	mov [rsp+-8],ebx
	; 	t7 = t6 * 4
	mov eax,[rsp+-8]
	mov ecx,4
	mul ecx
	mov [rsp+-4],eax
	; 	t8 = t0[t7]
	mov rax,t0
	xor rbx,rbx
	mov ebx,[rsp+-4]
	add rax,rbx
	mov eax,[rax]
	mov [rsp+-32],eax
	; 	out: t8
	mov rdi,fmtOutInt
	mov rsi,[rsp+-32]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
	section .data
t0:	 times 32 db 0
fmtOutInt: db "%d",10,0
fmtOutChar: db "%s",10,0
