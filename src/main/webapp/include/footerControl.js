/*
https 환경에서만 작동

function copyCode() {
  // 해당 div 요소를 변수에 받고,
  const code = document.querySelector(".tel");

  // window.navigator.clipboard.writeText() 메서드에
  // div 요소의 텍스트 내용을 (code.textContent) 인자로 넣어주면 끝!
  window.navigator.clipboard.writeText(code.textContent).then(() => {
    alert('전화번호가 복사되었습니다');
  });
};
*/

//클립보드 복사 부분
document.addEventListener('DOMContentLoaded', function() {
    const copyableElements = document.querySelectorAll('.copyable');

    copyableElements.forEach(element => {
        element.addEventListener('click', function() {
            // 텍스트 선택
            const range = document.createRange();
            range.selectNodeContents(element);
            window.getSelection().removeAllRanges();
            window.getSelection().addRange(range);

            // 클립보드에 복사
            try {
                document.execCommand('copy');
                window.getSelection().removeAllRanges(); // 선택 해제
                alert('텍스트가 클립보드에 복사되었습니다!');
            } catch (err) {
                alert('복사 중 오류가 발생했습니다.');
            }
        });
    });
});

/*
Deprecated
DOMContentLoaded 이벤트 리스너를 추가하여 DOM이 완전히 로드된 후 스크립트가 실행되도록 합니다.
querySelectorAll 메서드를 사용하여 copyable 클래스를 가진 모든 요소를 선택합니다.
forEach 메서드를 사용하여 각 요소에 클릭 이벤트 리스너를 추가합니다.
클릭 시, createRange와 getSelection 메서드를 사용하여 해당 요소의 텍스트를 선택합니다.
execCommand('copy') 메서드를 사용하여 선택된 텍스트를 클립보드에 복사합니다.
복사가 성공적으로 이루어지면 알림 메시지를 표시합니다
*/