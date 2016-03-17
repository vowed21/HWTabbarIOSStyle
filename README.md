
# HWTabbar

- 안드로이드의 ViewPager 와 연동되는 iOS 스타일의 탭바입니다.
- 뱃지 적용됩니다.


## 프로젝트에 추가.

Module.Gradle 에 설정.

```
dependencies 
{
	...
	compile 'com.kokohapps:hwtabbar-ios-style:1.1'
}
```



### 요구사항
- android.support.v4.view.ViewPager 사용해야함.
- 탭의 수 제한은 6개 입니다. (스크롤되는 스트랩이 아님)
- 탭바아이템에는 기본아이콘 이미지 + 선택아이콘 이미지 + 제목이 지정되야하며, 그 갯수가 6개 이하로 다 동일해야 합니다. 동일하지 않으면 Exception 날려버림.ㅋ

### 이닛.

```
protected void onCreate(Bundle savedInstanceState) {
	...
	ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
	HWTabbar tabbar = (HWTabbar)findViewById(R.id.tabbar);
	try {
            tabbar.initTabbar(viewPager, 제목배열, 기본아이콘배열, 선택아이콘배열, 선택됐을때색상지정);
        }
        catch (Exception e){
            e.printStackTrace();
        }
}
```


### 뱃지설정.
* public void setBadge(int tabbarItemPosition, String badgeValue);


```
	tabbar.setBadge(0, "23");
	tabbar.setBadge(1, "wow");
```

### 뱃지제거.
* setBadge()메소드에, 아이템번호와, nil을 날려주면 됨.


```
	tabbar.setBadge(0, nil);
```





#Example



<p align="center" >
  <img width="300" src="http://blogfiles.naver.net/20160311_140/vowed_14576797246552UATR_PNG/2016-03-11-15-15-41.png">
</p>


## License

- 일단은 MIT... 근데 뭐 라이센스나 붙일코드는 아닌듯. ㅋ







