// js/scripts.js

// 인증 헤더 추가 함수
function authFetch(url, options = {}) {
  const token = localStorage.getItem('accessToken');
  const headers = {
    ...(options.headers || {}),
    'Authorization': 'Bearer ' + token,
  };
  return fetch(url, { ...options, headers });
}

// 페이지 로드 시 실행되도록
document.addEventListener('DOMContentLoaded', function() {

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

   // 로그인 처리
   document.getElementById('loginForm').addEventListener('submit', async (e) => {
       e.preventDefault();
       const username = document.getElementById('login-username').value;
       const password = document.getElementById('login-password').value;

       const formData = new URLSearchParams();
       formData.append("username", username);
       formData.append("password", password);

       const res = await fetch('/login', {
           method: 'POST',
           headers: {
               'Content-Type': 'application/x-www-form-urlencoded'
           },
           body: formData
       });

       if (res.ok) {
           const access = res.headers.get("access");
           const refresh = getCookie("refresh");
           localStorage.setItem("accessToken", access);
          // fetchCurrentUser(access);
           document.getElementById('login-result').innerHTML = `
             <div>Access Token: <code>${access}</code></div>
             <div>Refresh Token: <code>${refresh}</code></div>
             <button onclick="goSwagger('${access}')">Swagger UI로 이동</button>
           `;
           window.location.href = '/push_list.html';
       } else {
           alert('로그인 실패');
       }
   });

   // 쿠키에서 refresh 토큰 가져오기
   function getCookie(name) {
       const matches = document.cookie.match(new RegExp(
           "(?:^|; )" + name + "=([^;]*)"
       ));
       return matches ? decodeURIComponent(matches[1]) : null;
   }

       // 회원가입 처리
       document.getElementById('signup-form').addEventListener('submit', async (e) => {
           e.preventDefault();
           const username = document.getElementById('signup-username').value;
           const password = document.getElementById('signup-password').value;
           const role = document.getElementById('signup-role').value;

           const res = await fetch('/join', {
               method: 'POST',
               headers: { 'Content-Type': 'application/json' },
               body: JSON.stringify({ username, password, role })
           });

           if (res.ok) {
               document.getElementById('signup-result').innerText = "회원가입 성공! 로그인 해보세요.";
           } else {
               document.getElementById('signup-result').innerText = "회원가입 실패";
           }
       });

        function goSwagger(token) {
            localStorage.setItem('swagger_access_token', token);
            location.href = "/swagger-ui/index.html";
        }

       // 모달 관련 요소들
       const modal = document.getElementById('signup-modal');
       const openSignupBtn = document.getElementById('open-signup');
       const closeModalBtn = document.getElementById('close-modal');

       // 모달 열기
       if (openSignupBtn) {
         openSignupBtn.addEventListener('click', function() {
           if (modal) {
             modal.style.display = 'block';
           }
         });
       }

       // 모달 닫기 (X 버튼)
       if (closeModalBtn) {
         closeModalBtn.addEventListener('click', function() {
           if (modal) {
             modal.style.display = 'none';
           }
         });
       }

       // 모달 외부 클릭시 닫기
       window.addEventListener('click', function(e) {
         if (e.target === modal) {
           modal.style.display = 'none';
         }
       });

    async function fetchCurrentUser(access) {
    const res = await fetch('/me', {
        method: 'GET',
        headers: {
            'Authorization': 'Bearer ' + access // or accessToken
        }
    });

    if (res.ok) {
        const username = await res.text();
   document.getElementById('login-result').innerHTML = `
             <div>username: <code>${username}</code></div>

           `;
    } else {
        alert("유저 정보 불러오기 실패");
    }
  }

});
