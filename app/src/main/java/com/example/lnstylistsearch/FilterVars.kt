package com.example.lnstylistsearch

import android.app.Application

class FilterVars : Application() {
    // Same lists across all categories
    val posed: Array<String> = resources.getStringArray(R.array.posed_options)
    val specialAttributes: Array<String> = resources.getStringArray(R.array.special_attributes)
    val rarity: Array<String> = resources.getStringArray(R.array.rarity)
    val gallery: Array<String> = resources.getStringArray(R.array.gallery_section)

    // lists different for different categories
    private val color1 = resources.getStringArray(R.array.color_1_ops)
    private val color2 = resources.getStringArray(R.array.color_2_ops)

    private val color1Hair = resources.getStringArray(R.array.color_1_hair_ops)
    private val color2Hair = resources.getStringArray(R.array.color_2_hair_ops)

    private val style1Hair = resources.getStringArray(R.array.hair1)
    private val style1Dress = resources.getStringArray(R.array.dress1)
    private val style1Coats = resources.getStringArray(R.array.coat1)
    private val style1Tops = resources.getStringArray(R.array.tops1)
    private val style1Bottoms = resources.getStringArray(R.array.bottoms1)
    private val style1Hosiery = resources.getStringArray(R.array.hosiery1)
    private val style1Shoes = resources.getStringArray(R.array.shoes1)
    private val style1Accessories = resources.getStringArray(R.array.accessories1)
    private val style1Makeup = resources.getStringArray(R.array.makeup1)
    private val style1Soul = resources.getStringArray(R.array.soul1)

    private val style2Hair = resources.getStringArray(R.array.hair2)
    private val style2Dress = resources.getStringArray(R.array.dress2)
    private val style2Coats = resources.getStringArray(R.array.coat2)
    private val style2Tops = resources.getStringArray(R.array.tops2)
    private val style2Bottoms = resources.getStringArray(R.array.bottoms2)
    private val style2Hosiery = resources.getStringArray(R.array.hosiery2)
    private val style2Shoes = resources.getStringArray(R.array.shoes2)
    private val style2AccessoriesSoul = resources.getStringArray(R.array.accessories_soul2)
    private val style2Makeup = resources.getStringArray(R.array.makeup2)

    // selectors lists
    var color1Sel: BooleanArray
    var color2Sel: BooleanArray
    var style1Sel: BooleanArray
    var style2Sel: BooleanArray
    var posedSel: BooleanArray
    var specialAttributes1Sel: BooleanArray
    var specialAttributes2Sel: BooleanArray
    var raritySel: BooleanArray
    var gallerySel: BooleanArray

    // category list (10 total)
    private val categories = resources.getStringArray(R.array.category_array)

    // determines which list is returned and set
    private var _currCategory = "Hair"
    private var currCategory
        get() = _currCategory
        set(nVal: String) {
            _currCategory = nVal
            // reset selections when switching category
            if (_currCategory == categories[0]) /*Hair*/ {
                color1Sel = BooleanArray(color1Hair.size)
                color2Sel = BooleanArray(color2Hair.size)
            } else /*All others*/ {
                color1Sel = BooleanArray(color1.size)
                color2Sel = BooleanArray(color2.size)
            }
            when (_currCategory) {
                categories[0] -> /*Hair*/ {
                    style1Sel = BooleanArray(style1Hair.size)
                    style2Sel = BooleanArray(style2Hair.size)
                }
                categories[1] -> /*Dress*/ {
                    style1Sel = BooleanArray(style1Dress.size)
                    style2Sel = BooleanArray(style2Dress.size)
                }
                categories[2] -> /*Coats*/ {
                    style1Sel = BooleanArray(style1Coats.size)
                    style2Sel = BooleanArray(style2Coats.size)
                }
                categories[3] -> /*Tops*/ {
                    style1Sel = BooleanArray(style1Tops.size)
                    style2Sel = BooleanArray(style2Tops.size)
                }
                categories[4] -> /*Bottoms*/ {
                    style1Sel = BooleanArray(style1Bottoms.size)
                    style2Sel = BooleanArray(style2Bottoms.size)
                }
                categories[5] -> /*Hosiery*/ {
                    style1Sel = BooleanArray(style1Hosiery.size)
                    style2Sel = BooleanArray(style2Hosiery.size)
                }
                categories[6] -> /*Shoes*/ {
                    style1Sel = BooleanArray(style1Shoes.size)
                    style2Sel = BooleanArray(style2Shoes.size)
                }
                categories[7] -> /*Accessories*/ {
                    style1Sel = BooleanArray(style1Accessories.size)
                    style2Sel = BooleanArray(style2AccessoriesSoul.size)
                }
                categories[8] -> /*Makeup*/ {
                    style1Sel = BooleanArray(style1Makeup.size)
                    style2Sel = BooleanArray(style2Makeup.size)
                }
                categories[9] -> /*Soul*/ {
                    style1Sel = BooleanArray(style1Soul.size)
                    style2Sel = BooleanArray(style2AccessoriesSoul.size)
                }
                else -> /*required else*/{
                    style1Sel = BooleanArray(style1Hair.size)
                    style2Sel = BooleanArray(style2Hair.size)
                }
            }

            posedSel = BooleanArray(posed.size)
            specialAttributes1Sel = BooleanArray(specialAttributes.size)
            specialAttributes2Sel = BooleanArray(specialAttributes.size)
            raritySel = BooleanArray(rarity.size)
            gallerySel = BooleanArray(gallery.size)
        }

    init {
        // initialize all selections to false
        color1Sel = BooleanArray(color1Hair.size)
        color2Sel = BooleanArray(color2Hair.size)
        style1Sel = BooleanArray(style1Hair.size)
        style2Sel = BooleanArray(style1Hair.size)
        posedSel = BooleanArray(posed.size)
        specialAttributes1Sel = BooleanArray(specialAttributes.size)
        specialAttributes2Sel = BooleanArray(specialAttributes.size)
        raritySel = BooleanArray(rarity.size)
        gallerySel = BooleanArray(gallery.size)
    }

    fun getClr1() : Array<String> {
        return if (currCategory == "Hair") {
            color1Hair
        } else {
            color1
        }
    }

    fun getClr2() : Array<String> {
        return if (currCategory == "Hair") {
            color2Hair
        } else {
            color2
        }
    }

    fun getStyle1() : Array<String>  {
        return when (currCategory) {
            categories[0] -> style1Hair
            categories[1] -> style1Dress
            categories[2] -> style1Coats
            categories[3] -> style1Tops
            categories[4] -> style1Bottoms
            categories[5] -> style1Hosiery
            categories[6] -> style1Shoes
            categories[7] -> style1Accessories
            categories[8] -> style1Makeup
            categories[9] -> style1Soul
            else -> style1Hair // required but unnecessary
        }
    }

    fun getStyle2() : Array<String> {
        return when (currCategory) {
            categories[0] -> style2Hair
            categories[1] -> style2Dress
            categories[2] -> style2Coats
            categories[3] -> style2Tops
            categories[4] -> style2Bottoms
            categories[5] -> style2Hosiery
            categories[6] -> style2Shoes
            categories[7] -> style2AccessoriesSoul
            categories[8] -> style2Makeup
            categories[9] -> style2AccessoriesSoul
            else -> style1Hair // required but unnecessary
        }
    }
}