/*
 * Copyright 2014-2016 Fukurou Mishiranu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package chan.http;

import chan.annotation.Public;
import chan.util.StringUtils;

@Public
public final class CookieBuilder {
	private final StringBuilder mBuilder = new StringBuilder();

	@Public
	public CookieBuilder() {}

	public CookieBuilder(CookieBuilder builder) {
		append(builder);
	}

	@Public
	public CookieBuilder append(String name, String value) {
		if (!StringUtils.isEmpty(value)) {
			if (mBuilder.length() > 0) {
				mBuilder.append("; ");
			}
			mBuilder.append(name).append("=").append(value);
		}
		return this;
	}

	public CookieBuilder append(String cookie) {
		if (!StringUtils.isEmpty(cookie)) {
			if (cookie.matches(".*; *")) {
				cookie = cookie.substring(0, cookie.lastIndexOf(';'));
			}
			if (mBuilder.length() > 0) {
				mBuilder.append("; ");
			}
			mBuilder.append(cookie);
		}
		return this;
	}

	public CookieBuilder append(CookieBuilder builder) {
		if (builder != null) {
			if (mBuilder.length() > 0) {
				mBuilder.append("; ");
			}
			mBuilder.append(builder.mBuilder);
		}
		return this;
	}

	@Public
	public String build() {
		return mBuilder.toString();
	}
}