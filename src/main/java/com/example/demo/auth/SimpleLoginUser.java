package com.example.demo.auth;

import com.example.demo.entity.User2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ユーザー認証情報
 */
@Slf4j
public class SimpleLoginUser extends org.springframework.security.core.userdetails.User {
  // DBより検索したuserエンティティ
  // 認証・認可以外でアプリケーションから利用されるのでフィールドに定義
  private User2 user;

  /**
   * データベースより検索したuserエンティティよりSpring Securityで使用するユーザー認証情報の
   * インスタンスを生成する
   *
   * @param user userエンティティ
   */
  public SimpleLoginUser(User2 user) {
    super(user.getEmail(), user.getPassword(), user.getEnable(), true, true,
        true, convertGrantedAuthorities(user.getRoles()));
    this.user = user;
  }

  public User2 getUser() {
    return user;
  }

  /**
   * カンマ区切りのロールをSimpleGrantedAuthorityのコレクションへ変換する
   *
   * @param roles カンマ区切りのロール
   * @return SimpleGrantedAuthorityのコレクション
   */
  static Set<GrantedAuthority> convertGrantedAuthorities(String roles) {
    if (roles == null || roles.isEmpty()) {
      return Collections.emptySet();
    }
    Set<GrantedAuthority> authorities = Stream.of(roles.split(","))
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toSet());
    return authorities;
  }

}
