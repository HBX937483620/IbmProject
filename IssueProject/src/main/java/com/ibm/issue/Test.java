package com.ibm.issue;

public class Test {
	public static void main(String[] args) {
		for (int E = 0; E < 10; E++) {
			if (E == 4) {
				continue;
			}else {
				for (int V = 0; V < 10; V++) {
					if (V == 4 || V == E ) {
						continue;
					}else {
						for (int Y = 0; Y < 10; Y++) {
							if (Y == 4 || Y == E || Y == V) {
								continue;
							}else {
								for (int R = 0; R < 10; R++) {
									if (R == 4 || R == E || R == V || R == Y) {
										continue;
									}else {
										for (int Z = 0; Z < 10; Z++) {
											if (Z == 4 || Z == E || Z == V || Z == Y || Z == R) {
												continue;
											}else {
												for (int O = 0; O < 10; O++) {
													if (O == 4 || O == E || O == V || O == Y || O == R ||O == Z) {
														continue;
													}else {
														for (int N = 0; N < 10; N++) {
															if (N == 4 || N == E || N == V || N == Y || N == R ||N == Z || N ==O) {
																continue;
															}else {
																for (int G = 0; G < 10; G++) {
																	if (G == 4 || G == E || G == V || G == Y || G == R ||G == Z || G ==O || G ==N) {
																		continue;
																	}else {
																		for (int M = 0; M < 10; M++) {
																			if (M == 4 || M == E || M == V || M == Y || M == R ||M == Z || M ==O || M ==N || M==G) {
																				continue;
																			}else {
																				if ((E+10*V+100*Z+1000*G)+(E+10*R+100*O+1000*M) == (Y+10*E+100*N+O*1000+M*10000)) {
																					System.out.println(M + " " + O + " " + G);
																	
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(111);
	}
}
