package com.starters.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.starters.calculator_app.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private var isOperator = false
    private var hasOperator = false
    private var isGt = false

    private var lastNumeric: Boolean = false
    private var lastDot: Boolean = false

    private var total: Double = 0.0
    private var gt = mutableListOf<Double>()

    private var plus = false
    private var minus = false
    private var multi = false
    private var divide = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        onGT()
        setDeleteButton()
        notWorkButton()
        onEqual()

        onSqrt()
        appendDecimalPoint()
    }

    fun buttonClicked(v: View) {
        when (v.id) {
            R.id.btn_zero -> numberButtonClicked("0")
            R.id.btn_one -> numberButtonClicked("1")
            R.id.btn_two -> numberButtonClicked("2")
            R.id.btn_three -> numberButtonClicked("3")
            R.id.btn_four -> numberButtonClicked("4")
            R.id.btn_five -> numberButtonClicked("5")
            R.id.btn_six -> numberButtonClicked("6")
            R.id.btn_seven -> numberButtonClicked("7")
            R.id.btn_eight -> numberButtonClicked("8")
            R.id.btn_nine -> numberButtonClicked("9")
            R.id.btn_double_zero -> numberButtonClicked("00")
            R.id.btn_plus -> operatorButtonClicked("+")
            R.id.btn_subtract -> operatorButtonClicked("-")
            R.id.btn_multiply -> operatorButtonClicked("×")
            R.id.btn_divide -> operatorButtonClicked("÷")
            R.id.btn_percent -> operatorButtonClicked("%")
        }
    }

    private fun numberButtonClicked(number: String) {
        val text = binding.tvExpression.text

        if (text.toString() == "0" || isGt) {
            binding.tvExpression.text = ""
            binding.btnZero.isEnabled = false
            binding.btnDoubleZero.isEnabled = false
            isGt = false
            lastNumeric = true
            //lastDot = false
        } else {
            binding.btnZero.isEnabled = true
            binding.btnDoubleZero.isEnabled = true
            lastNumeric = true
            //lastDot = false
        }

        if (isOperator) {
            binding.tvExpression.text = ""
        }

        isOperator = false



        binding.tvExpression.append(number)
        //binding.tvExpression.text = calculateExpression()

    }

    private fun operatorButtonClicked(operator: String) {

        isOperator = true

        if (binding.tvOperator.text == operator) {

        }

        when {
            isOperator -> {
                when (operator) {
                    "+" -> {
                        if (plus) {
                            total += binding.tvExpression.text.toString().toDouble()
                        } else if (minus) {
                            total -= binding.tvExpression.text.toString().toDouble()
                        } else if (multi) {
                            total *= binding.tvExpression.text.toString().toDouble()
                        } else if (divide) {
                            total /= binding.tvExpression.text.toString().toDouble()
                        } else {
                            total = binding.tvExpression.text.toString().toDouble()
                        }

                        plus = true
                        minus = false
                        multi = false
                        divide = false
                        lastDot = false

                        binding.tvOperator.text = operator

                        if (total != 0.0) {
                            if (binding.rbtnCut.isChecked) {
                                if (binding.rbtnAdd.isChecked) {
                                    binding.tvExpression.text = applyAdd2(total.toString())
                                } else {
                                    binding.tvExpression.text = applyCutting(total.toString())
                                }
                            } else if (binding.rbtnRounding.isChecked) {
                                binding.tvExpression.text = applyAdd2(total.toString())
                            } else {
                                binding.tvExpression.text = removeZeroAfterDot(total.toString())
                            }
                        }


                    }
                    "-" -> {
                        if (plus) {
                            total += binding.tvExpression.text.toString().toDouble()
                        } else if (minus) {
                            total -= binding.tvExpression.text.toString().toDouble()
                        } else if (multi) {
                            total *= binding.tvExpression.text.toString().toDouble()
                        } else if (divide) {
                            total /= binding.tvExpression.text.toString().toDouble()
                        } else {
                            total = binding.tvExpression.text.toString().toDouble()
                        }

                        plus = false
                        minus = true
                        multi = false
                        divide = false
                        lastDot = false

                        binding.tvOperator.text = operator

                        if (total != 0.0) {
                            if (binding.rbtnCut.isChecked) {
                                if (binding.rbtnAdd.isChecked) {
                                    binding.tvExpression.text = applyAdd2(total.toString())
                                } else {
                                    binding.tvExpression.text = applyCutting(total.toString())
                                }
                            } else if (binding.rbtnRounding.isChecked) {
                                binding.tvExpression.text = applyAdd2(total.toString())
                            } else {
                                binding.tvExpression.text = removeZeroAfterDot(total.toString())
                            }

                        }

                    }
                    "×" -> {
                        if (plus) {
                            total += binding.tvExpression.text.toString().toDouble()
                        } else if (minus) {
                            total -= binding.tvExpression.text.toString().toDouble()
                        } else if (multi) {
                            total *= binding.tvExpression.text.toString().toDouble()
                        } else if (divide) {
                            total /= binding.tvExpression.text.toString().toDouble()
                        } else {
                            total = binding.tvExpression.text.toString().toDouble()
                        }

                        plus = false
                        minus = false
                        multi = true
                        divide = false
                        lastDot = false

                        binding.tvOperator.text = operator

                        if (total != 0.0) {
                            if (binding.rbtnCut.isChecked) {
                                if (binding.rbtnAdd.isChecked) {
                                    binding.tvExpression.text = applyAdd2(total.toString())
                                } else {
                                    binding.tvExpression.text = applyCutting(total.toString())
                                }
                            } else if (binding.rbtnRounding.isChecked) {
                                binding.tvExpression.text = applyAdd2(total.toString())
                            } else {
                                binding.tvExpression.text = removeZeroAfterDot(total.toString())
                            }


                        }


                    }
                    "÷" -> {
                        if (plus) {
                            total += binding.tvExpression.text.toString().toDouble()
                        } else if (minus) {
                            total -= binding.tvExpression.text.toString().toDouble()
                        } else if (multi) {
                            total *= binding.tvExpression.text.toString().toDouble()
                        } else if (divide) {
                            total /= binding.tvExpression.text.toString().toDouble()
                        } else {
                            total = binding.tvExpression.text.toString().toDouble()
                        }

                        plus = false
                        minus = false
                        multi = false
                        divide = true
                        lastDot = false

                        binding.tvOperator.text = operator

                        if (total != 0.0) {
                            if (binding.rbtnCut.isChecked) {
                                if (binding.rbtnAdd.isChecked) {
                                    binding.tvExpression.text = applyAdd2(total.toString())
                                } else {
                                    binding.tvExpression.text = applyCutting(total.toString())
                                }
                            } else if (binding.rbtnRounding.isChecked) {
                                binding.tvExpression.text = applyAdd2(total.toString())
                            } else {
                                binding.tvExpression.text = removeZeroAfterDot(total.toString())
                            }

                        }

                    }
                }

            }
            hasOperator -> {
                binding.tvK.visibility = View.VISIBLE
                return

            }
            else -> {
                //expressionTextView.append(" $operator")
            }
        }
        isOperator = true
        hasOperator = true
    }

    private fun setChangeSignButton() {
        //binding.btnChangeSign.text
    }

    private fun setDeleteButton() {
        // 숫자 하나씩 지우기
        binding.btnBack.setOnClickListener {
            val number = binding.tvExpression.text
            if (number.isNotEmpty()) {
                binding.tvExpression.text = number.substring(0, number.length - 1)
            }
        }

        // 현재 입력만 지우기
        binding.btnC.setOnClickListener {
            val number = binding.tvExpression.text
            if (number.isNotEmpty()) {
                binding.tvExpression.text = ""
            }
        }

        // 전체 입력 & GT 지우기
        binding.btnAc.setOnClickListener {
            val number = binding.tvExpression.text
            binding.tvExpression.text = "0"
            binding.tvOperator.text = ""
            binding.tvGt.visibility = View.INVISIBLE
            binding.tvK.visibility = View.INVISIBLE
            total = 0.0
            gt.clear()
        }
    }

    private fun notWorkButton() {
        binding.btnHms.setOnClickListener {
            Toast.makeText(this, "기능 구현 예정입니다", Toast.LENGTH_SHORT).show()
        }

        binding.btnPercent.setOnClickListener {
            Toast.makeText(this, "기능 구현 예정입니다", Toast.LENGTH_SHORT).show()
        }
    }

    private fun appendDecimalPoint() {
        binding.btnDot.setOnClickListener {
            val text = binding.tvExpression.text
            if (text == "") {
                return@setOnClickListener
            } else if (lastNumeric && !lastDot) {
                binding.tvExpression.append(".")
                lastDot = true
            }
        }
    }

    private fun onEqual() {
        binding.btnEqual.setOnClickListener {
            if (plus) {
                total += binding.tvExpression.text.toString().toDouble()
            } else if (minus) {
                total -= binding.tvExpression.text.toString().toDouble()
            } else if (multi) {
                total *= binding.tvExpression.text.toString().toDouble()
            } else if (divide) {
                total /= binding.tvExpression.text.toString().toDouble()
            } else {
                total = binding.tvExpression.text.toString().toDouble()
            }

            if (binding.rbtnCut.isChecked) {
                if (binding.rbtnAdd.isChecked) {
                    binding.tvExpression.text = applyAdd2(total.toString())
                } else {
                    binding.tvExpression.text = applyCutting(total.toString())
                }
            } else if (binding.rbtnRounding.isChecked) {
                binding.tvExpression.text = applyAdd2(total.toString())
            } else {
                binding.tvExpression.text = removeZeroAfterDot(total.toString())
            }

            gt.add(total)
            total = 0.0

            plus = false
            minus = false
            multi = false
            divide = false
            isGt = true
            lastDot = false

            binding.tvOperator.text = ""
            binding.tvGt.visibility = View.VISIBLE
        }
    }

    private fun onGT() {
        binding.btnGt.setOnClickListener {
            var totalGt: Double = 0.0
            for (i in gt) {
                totalGt += i
            }


            if (binding.rbtnCut.isChecked) {
                if (binding.rbtnAdd.isChecked) {
                    binding.tvExpression.text = applyAdd2(totalGt.toString())
                } else {
                    binding.tvExpression.text = applyCutting(totalGt.toString())
                }
            } else if (binding.rbtnRounding.isChecked) {
                binding.tvExpression.text = applyAdd2(total.toString())
            } else {
                binding.tvExpression.text = removeZeroAfterDot(totalGt.toString())
            }
        }

    }

    private fun onSqrt() {
        binding.btnRoot.setOnClickListener {
            var textToDouble = binding.tvExpression.text.toString().toDouble()
            var sqrt = sqrt(textToDouble)
            binding.tvExpression.text = sqrt.toString()
        }
    }

    private fun removeZeroAfterDot(result: String): String {
        var value = result

        if (result.contains(".0")) {
            var numberNextDot = value.split(".")[1]
            if (numberNextDot.length <= 1) {
                value = result.substring(0, result.length - 2)
            }
        }

        return value
    }

    private fun applyCutting(result: String): String {
        var value = result
        binding.radioGroup2.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbtn_4 -> {
                    if (result.contains(".")) {
                        var numberNextDot = value.split(".")[1]
                        if (numberNextDot.length >= 4) {
                            value =
                                result.split(".")[0] + "." + result.split(".")[1].substring(0, 4)
                        } else {
                            value = result
                        }
                    }
                    else removeZeroAfterDot(value)
                }

                R.id.rbtn_3 -> {
                    if (result.contains(".")) {
                        var numberNextDot = value.split(".")[1]
                        if (numberNextDot.length >= 3) {
                            value =
                                result.split(".")[0] + "." + result.split(".")[1].substring(0, 3)
                        } else {
                            value = result
                        }
                    }

                }

                R.id.rbtn_2 -> {
                    if (result.contains(".")) {
                        var numberNextDot = value.split(".")[1]
                        if (numberNextDot.length >= 2) {
                            value =
                                result.split(".")[0] + "." + result.split(".")[1].substring(0, 2)
                        } else {
                            value = result
                        }
                    }

                }

                R.id.rbtn_1 -> {
                    if (result.contains(".")) {
                        var numberNextDot = value.split(".")[1]
                        if (numberNextDot.length >= 1) {
                            value =
                                result.split(".")[0] + "." + result.split(".")[1].substring(0, 1)
                        } else {
                            value = result
                        }
                    }

                }

                R.id.rbtn_0 -> {
                    if (result.contains(".")) {
                        var numberNextDot = value.split(".")[1]
                        if (numberNextDot.length >= 0) {
                            value =
                                result.split(".")[0] + "." + result.split(".")[1].substring(0, 4)
                        } else {
                            value = result
                        }
                    }

                }
            }
        }
        return value
    }


    private fun applyRounding(result: String): String {
        var value = result
        if (binding.rbtn4.isChecked) {
            if (result.contains(".")) {
                var numberNextDot = value.split(".")[1]
                if (numberNextDot.length == 4) {
                    if (numberNextDot.last() >= '5') {
                        value = result.split(".")[0] + "." + (numberNextDot.toInt() + 1).toString()
                    } else {
                        value = result.split(".")[0] + "." + numberNextDot
                    }

                } else if (numberNextDot.length > 4) {
                    if (numberNextDot.substring(4, 5).toInt() >= 5) {
                        value = result.split(".")[0] + "." + (numberNextDot.substring(0, 4)
                            .toInt() + 1).toString()
                    } else {
                        value = result.split(".")[0] + "." + numberNextDot.substring(0, 4)
                    }
                }
            }
        } else {
            value
        }

        if (binding.rbtn3.isChecked) {
            if (result.contains(".")) {
                var numberNextDot = value.split(".")[1]
                if (numberNextDot.length >= 3) {
                    value = result.split(".")[0] + "." + numberNextDot.substring(0, 3)
                }
            }
        } else {
            value
        }

        if (binding.rbtn2.isChecked) {
            if (result.contains(".")) {
                var numberNextDot = value.split(".")[1]
                if (numberNextDot.length >= 2) {
                    value = result.split(".")[0] + "." + numberNextDot.substring(0, 2)
                }
            }
        } else {
            value
        }

        if (binding.rbtn1.isChecked) {
            if (result.contains(".")) {
                var numberNextDot = value.split(".")[1]
                if (numberNextDot.length >= 1) {
                    value = result.split(".")[0] + "." + numberNextDot.substring(0, 1)
                }
            }
        } else {
            value
        }

        if (binding.rbtn0.isChecked) {
            if (result.contains(".")) {
                var numberNextDot = value.split(".")[1]
                if (numberNextDot.length >= 0) {
                    value = result.split(".")[0]
                }
            }
        } else {
            value = result.split(".")[0]
        }
        return value
    }

    private fun applyAdd2(result: String): String {
        return (result.toDouble() / 100).toString()
    }

}