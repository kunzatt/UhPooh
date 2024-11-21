import axios from "axios";
import { ref } from "vue";
const userAuthenticated = ref(false);

const isAuthenticated = async () => {
  console.log("start validation!!!");
  const token = localStorage.getItem("userToken");
  if (!token) return false;

  try {
    // 서버로 토큰 검증 요청

    const response = await axios.get("/api/user/validate", {
      params: {
        userId: localStorage.getItem("userId"),
        accessToken: token,
      },
    });
    userAuthenticated.value = true; // 서버에서 유효성 확인 결과 반환
    console.log("검증 성공");
  } catch (error) {
    console.error("Token validation failed:", error);
    userAuthenticated.value = false;
    return false;
  }
};

const getUserInfo = async () => {
  console.log("Fetch user data!!!");
  console.log(userAuthenticated.value);
  console.log(localStorage.getItem("userId"));
  const userId = localStorage.getItem("userId");

  if (!userId) {
    console.error("No userId found in localStorage!");
    return;
  }

  try {
    const response = await axios.get(
      `http://localhost:8080/uhpooh/api/user/${userId}`,
      {
        params: {
          requestUserId: userId,
        },
      }
    );
    localStorage.setItem("userName", response.data.data.userName);
    localStorage.setItem("userAddress", response.data.data.userAddress);
    localStorage.setItem("pImage", response.data.data.pImage);
    localStorage.setItem("userEmail", response.data.data.userEmail);
    localStorage.setItem("regTime", response.data.data.regTime);
    localStorage.setItem("isAdmin", response.data.data.isAdmin);
    localStorage.setItem("chatId", response.data.data.chatId);
  } catch (error) {
    console.log(error);
  }
};

export { isAuthenticated, getUserInfo, userAuthenticated };
