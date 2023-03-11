# 🗺️ 드라마 촬영지 기반 한국 여행 서비스 

![image 148](https://user-images.githubusercontent.com/98886487/221552738-58ba3d1c-538c-4931-86b2-23329b7f7306.png)
프로젝트명 : [FIKA] Find-In-Korea-Drama   
개발 기간 : 2022.07 ~ 2022.09   
팀원 및 역할 : 기획/마케팅/데이터 5명, UI/UX 디자이너 1명, Android 프론트엔드 개발 2명, 백엔드 개발 1명   

## 💡 Topic
* 일본인 대상 K-드라마 촬영지를 기반으로 한국의 관광지를 추천하고 여행 코스를 제공하는 여행서비스 앱
* 2022 관광데이터 활용 공모전 출품작 [우수상] 

## 📝 Description
> 일본 내에서 K-Pop과 더불어 한류 열풍의 주역이라 할 수 있는 K-Drama, 그 중에서도 드라마 촬영지와 주변 관광지를 중심으로 사용자가 직접 여행 코스를 설계하는 서비스입니다. 
드라마를 보는 시청자의 입장에서 “아! 저기 어디지? 한 번 가보고 싶다”라는 가정에서 시작해 아이디어를 구체화했습니다.<br><br>
관광지 정보는 한국관광공사의 'TourAPI 4.0'에서 제공하는 관광데이터를 활용했습니다.
그리고 공모전 제출 당시 ‘이태원 클라스’, ‘이상한 변호사 우영우’의 제작사에 직접 문의해 해당 드라마의 포스터와 대본의 일부를 앱에 사용할 수 있는 권한을 허가 받았습니다.

## ✅ Main Function
<p>
일본인 대상 앱으로 일본어로 번역되어 있음에 양해부탁드립니다.
<div>
  <img src="https://user-images.githubusercontent.com/98886487/223594131-0bfef979-9b69-4bf3-85a4-8fd7b267a14f.png" width="200" height="400" /> 
  <img src="https://user-images.githubusercontent.com/98886487/221556632-a32c2490-6722-415a-9f1e-b05e4816a48e.png" width="200" height="400" /> 
  <img src="https://user-images.githubusercontent.com/98886487/221557928-223ce860-aec3-48da-92b4-ad3035c62a5f.png" width="200" height="400" />
</div>
</p>

### 1️⃣ 관광지 추천 기능   
* 한국에 낯선 일본인 관관객을 위해 드라마와 지역을 구분하여 관광지/관광 코스를 제공합니다.
* 해당 화면의 관광지는 모두 드라마 촬영지로 접근성이 좋은 인기 관광지 위주로 선택했습니다.
* 각각 최신순, 이름순 정렬이 가능하며 즐겨찾기 추가/삭제가 가능합니다.
<br>

<div>
  <img src="https://user-images.githubusercontent.com/98886487/224473841-ea02d5a8-5b51-48a2-9ec4-ecea3136e81d.png" width="200" height="400" /> 
</div>   

### 2️⃣ 사용자가 직접 만드는 K-Drama 여행 코스
* 드라마와 촬영지, 추천 여행지를 바탕으로 사용자가 직접 여행코스를 제작하고 해당 코스를 확인할 수 있습니다.
* 추천 관광지는 드라마 촬영지 주변 반경 10km를 기준으로 Tour API에서 제공하는 '맛집', '카페', '쇼핑' 카테고리로 구분하여 제공합니다.
<br>

<div> 
  <img src="https://user-images.githubusercontent.com/98886487/224475939-220585ae-a7bb-4df4-ab1f-0afb0e8dfb91.png" width="200" height="400" /> 
  <img src="https://user-images.githubusercontent.com/98886487/224475887-19dc757b-0811-4171-9abb-0b7d9ae671ee.png" width="200" height="400" /> 
  <img src="https://user-images.githubusercontent.com/98886487/224475963-8ca71c3b-bbbc-4edf-a947-201a988da7d8.png" width="200" height="400" />
  <img src="https://user-images.githubusercontent.com/98886487/224475996-ae655e87-6dbc-44c8-9d0d-d19c484ba643.png" width="200" height="400" />
</div>

### 3️⃣ 카카오맵을 통한 여행지 확인 및 교통편 확인 기능 
* 코스에 추가된 관광지는 지도의 Marker로 확인 가능하며, 한국 지리에 낯선 일본인을 위해 코스 좌측의 거리를 터치하면 두 관광지 사이의 교통편을 카카오맵을 통해 제공합니다.
* 다양한 카카오 API(Login, WebView, Maps, Navigation)를 사용해볼 수 있었습니다.
* 
<br>
