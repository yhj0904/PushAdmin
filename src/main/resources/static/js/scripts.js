// js/scripts.js

// 페이지 로드 시 실행되도록
document.addEventListener('DOMContentLoaded', function() {
  // 예: 로그인 폼 검증
  const loginForm = document.querySelector('#loginForm');
  if (loginForm) {
    loginForm.addEventListener('submit', function(e) {
      const idInput = document.querySelector('#inputId');
      const pwInput = document.querySelector('#inputPw');
      let valid = true;
      document.querySelectorAll('.error-msg').forEach(el => el.textContent = '');

      if (!idInput.value.trim()) {
        document.querySelector('#idError').textContent = '아이디를 입력해 주세요.';
        valid = false;
      }
      if (!pwInput.value.trim()) {
        document.querySelector('#pwError').textContent = '비밀번호를 입력해 주세요.';
        valid = false;
      }
      if (!valid) {
        e.preventDefault();
      }
    });
  }

  // 예: PUSH 생성 폼 검증
  const pushForm = document.querySelector('#pushCreateForm');
  if (pushForm) {
    pushForm.addEventListener('submit', function(e) {
      // 간단히 제목/내용이 비었는지만 체크
      const titleInput = document.querySelector('#pushTitle');
      const contentInput = document.querySelector('#pushContent');
      document.querySelectorAll('.error-msg').forEach(el => el.textContent = '');
      let valid = true;

      if (!titleInput.value.trim()) {
        document.querySelector('#titleError').textContent = '제목을 입력해 주세요.';
        valid = false;
      }
      if (!contentInput.value.trim()) {
        document.querySelector('#contentError').textContent = '내용을 입력해 주세요.';
        valid = false;
      }
      if (!valid) {
        e.preventDefault();
      }
    });
  }
});
