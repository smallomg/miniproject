<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>동물 사진 맞추기 퀴즈</title>
  <style>
    body {
      font-family: sans-serif;
      text-align: center;
      margin-top: 50px;
    }
    #animalImage {
      width: 300px;
      height: auto;
      border: 2px solid #ccc;
      border-radius: 10px;
      margin-bottom: 10px;
    }
    #feedback {
      font-weight: bold;
      margin-top: 10px;
    }
    #finalScore {
      font-size: 20px;
      color: green;
      margin-top: 20px;
    }
  </style>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
  <h1>동물 사진 보고 이름 맞추기!</h1>

  <img id="animalImage" src="images/elephant.jpg" alt="동물 사진">
  <br>
  <input type="text" id="answerInput" placeholder="이 동물의 이름은?">
  <button onclick="submitAnswer()">확인</button>

  <p id="feedback"></p>
  <p id="finalScore"></p>

  <script>
    const animalList = [
      { name: "코끼리", image: "images/elephant.jpg" },
      { name: "호랑이", image: "images/tiger.jpg" },
      { name: "기린", image: "images/giraffe.jpg" },
      { name: "판다", image: "images/panda.jpg" },
      { name: "사자", image: "images/lion.jpg" }
    ];

    let currentIndex = 0;
    let score = 0;

    function loadNextAnimal() {
      if (currentIndex >= animalList.length) {
        document.getElementById("animalImage").style.display = "none";
        document.getElementById("answerInput").style.display = "none";
        document.getElementById("feedback").innerText = "";
        document.getElementById("finalScore").innerText =
        	  "퀴즈 완료! 점수: " + score + " / " + animalList.length;

        return;
      }
      document.getElementById("animalImage").src = animalList[currentIndex].image;
      document.getElementById("answerInput").value = "";
      document.getElementById("feedback").innerText = "";
    }

    function submitAnswer() {
    	  const userAnswer = document.getElementById("answerInput").value.trim();
    	  const correct = animalList[currentIndex].name;

    	  if (userAnswer === correct) {
    	    score++;
    	    document.getElementById("feedback").innerText = "정답!";
    	  } else {
    	    document.getElementById("feedback").innerHTML = "틀렸습니다. <br>정답: " + correct;
    	  }

    	  currentIndex++;

    	  if (currentIndex >= animalList.length) {
    	    // 끝났을 때 점수 표시 및 버튼 변경
    	    setTimeout(() => {
    	      document.getElementById("animalImage").style.display = "none";
    	      document.getElementById("answerInput").style.display = "none";
    	      document.getElementById("feedback").innerText = "";
    	      document.getElementById("finalScore").innerText =
    	        "퀴즈 완료! 점수: " + score + " / " + animalList.length;

    	      // 버튼 텍스트 변경 및 동작 재설정
    	      const btn = document.querySelector("button");
    	      btn.innerText = "홈으로 돌아가기";
    	      btn.onclick = function () {
    	        location.reload(); // 페이지 새로고침으로 퀴즈 다시 시작
    	      };
    	    }, 1500);
    	  } else {
    	    setTimeout(loadNextAnimal, 1500); // 다음 퀴즈 로딩
    	  }
    	}

  </script>
</body>
</html>

