package com.myfauzan.submission


import com.myfauzan.submission.R.drawable.*

object AlbumData {
    private val albumNames = arrayOf(
        "2 Cool 4 Skool",
        "O!RUl8,_2",
        "SKOOL LUV AFFAIR",
        "Dark & Wild",
        "HYYH Pt1",
        "HYYH Pt2",
        "HYYH Forever Young",
        "Wings",
        "You Never Walk Alone",
        "Love Yourself 'Her'",
        "Love Yourself 'Tear'",
        "Love Yourself 'Answer'",
    )

    private val albumDetails = arrayOf(
        "Hip hop group BTS has released its debut single 2 COOL 4 SKOOL. While billed as a single, the album boasts an impressive 27-minute runtime. This is the product of the firm conviction and passion of BTS that hip hop musicians must make their voices heard through their albums. Each member flexed their musical prowess by taking part in creating the lyrics and music for every song on the album. BTS has repeatedly said that “hip hop is genuine music for telling one’s own story,” and indeed the members rap about their own experiences and emotions. There is no discontinuity between the emotions and lyrics of BTS. The album is a satisfaction in both quality and quantity.",
        "With O!RUL8,2? (Oh! Are you late, too?), BTS offers the message that “you must find your happiness and your own life before it’s too late.”\n" +
                "Lyrics that brutally lay open reality as it is deliver a bold admonition to a world that inflicts despair. Children are raised as studying machines without a chance to think about the future.\n" +
                "A world where classmates are not friends but competitors trying to trample each other. BTS sings about the wounds and anguish that such hopeless life has left on today’s teens. .",
        "With their previous two albums, 2 COOL 4 SKOOL and O!RUL8,2?, BTS sang about the dreams and happiness of teens. The songs spoke about young people living without a dream and schools that force rigid and homogenous thought onto its students. The new album, released on February 12, continues to focus on school and teens. As hinted by the title, SKOOL LUV AFFAIR, the album’s main theme is the love that blossoms in the school. This album is a culmination of the “School Trilogy” project that discusses the topics of most interest to teens their own age—dreams, happiness and love. Such penetrating insight into the hearts and minds of young people led to the absolute support that BTS has received from fans their age. The members again directly participated in the making of the songs, vowing to ensure that the songs reflect the reality of the music fans of their own generation.",
        "The boys are no longer in their school uniforms. They have become tougher, singing that their love is not to be treated lightly. A year and two months into their debut, BTS made sure that the visuals, performance and all the elements of their first studio album are flawless. Tracks that highlight the different genres of hip hop—South, West, Boom Bap and Trap—provide a clear direction of BTS' music. The title track “Danger” is a tightly-composed hybrid hip hop song with a piercing punk-rock guitar sound that features stark rap, a powerful hook and exhilarating shouting.",
        "BTS has come back with their third mini album, The most beautiful moment in life pt.1.\n" +
                "No longer just young boys, the album is an introduction to BTS as a group that continues to grow and develop. In each track are distilled poetic and pop emotions that allows the listener to sense both the soft and the resounding musical transformation of the group.",
        "Seven young men on the threshold of their 20s. Now entering their young adulthood, the members of BTS sang in their previous album, The most beautiful moment in life pt.1, about people their age being threatened by uncertainty. Released seven months after that first installment, The most beautiful moment in life pt.2 sings about the energy of youth barreling forward, embracing even the uncertainty and insecurity. Now beginning to taste the bitterness of grown-up life, they can easily sense that life isn't always beautiful. However, they continue to sprint forward, relying only on their two destitute legs and the fire in their hearts. There’s nothing else to do but keep running. Facing the powerlessness of one’s youth, they collide and shatter and still cry out that “it’s okay to fall, it’s okay to get hurt.” That is the beauty of this moment.",
        "Having won over the world with their two-part The most beautiful moment in life series in 2015, BTS will release their special album The most beautiful moment in life : YOUNG FOREVER on May 2. True to the title of the albums, the series has enabled BTS to now be in the most beautiful moment of their lives. The most beautiful moment in life : YOUNG FOREVER is a special album that marks the conclusion of the epic journey of the series, containing the last stories told by young people who, despite an uncertain and insecure reality (The most beautiful moment in life pt.1) continue to surge forward (The most beautiful moment in life pt.2).",
        "Having met their most beautiful moment in life through the ablum series of the same title, BTS now stands before a new door. Set for release on October 10, WINGS contains songs about boys who encounter temptation for the first time and must ponder and agonize in the face of it. As the seven boys experience pain and bliss, they bring forth the image of birds that break out of their shells and try to take flight for the first time.",
        "YOU NEVER WALK ALONE completes the stories of youth and growth that could not all be contained in the WINGS album. Whereas The most beautiful moment in life series and WINGS were narratives of youth and growth, this additional chapter to WINGS is a message of warm consolation and hope for the suffering youth of this generation.",
        "LOVE YOURSELF 承 'HER' is an expression of the anxiety and elation of love, told in the unique style of BTS. The “love” that BTS aims to convey in the LOVE YOURSELF series is both the individual experience of a boy growing into adulthood and a message of peace and unity to our society today. In the mini album 承 'HER' that begins this new narrative, the image of boys in love for the first time are expressed in a refreshing and cheerful take that aims to talk about the topic of “love” while immersed in a coming-of-age tale.",
        "BTS’ LOVE YOURSELF series bears the message that loving oneself is the beginning of true love. Whereas the previously unveiled LOVE YOURSELF 起 ‘WONDER’ and LOVE YOURSELF 承 ‘HER’ albums expressed the heart-fluttering and tingling moments of love, LOVE YOURSELF 轉 ‘TEAR’ album embodies the pain of boys faced with parting.",
        "ANSWER’ is the final piece of the puzzle. Though it’s a repackaged album, LOVE YOURSELF 結 ‘ANSWER’ still includes seven brand-new tracks. CD A is a concept album, its sixteen tracks all connected lyrically to highlight BTS’ prowess as both artists and storytellers."
    )

    private val albumImages = intArrayOf(
        sampel1_bts_2_cool_4_skool,
        sampel2_bts_o_rul8_2,
        sampel3_bts_skool_luv_affair,
        sampel4_bts_dark_n_wild,
        sampel5_bts_hyyh_pt1,
        sampel6_bts_hyyh_pt2,
        sampel7_bts_hyyh_young_forever,
        sampel8_bts_wings,
        sampel9_bts_you_never_walk_alone,
        sampel10_bts_love_yourself_her,
        sampel11_bts_love_yourself_tear,
        sampel12_bts_love_yourself_answer
    )

    val listData: ArrayList<Album>
        get(){
            val list = arrayListOf<Album>()
            for (position in albumNames.indices){
                val album = Album()
                album.name = albumNames[position]
                album.detail = albumDetails[position]
                album.photo = albumImages[position]
                list.add(album)
            }
            return list
        }
}