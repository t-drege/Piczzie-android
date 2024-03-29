package com.ziggy.kdo.ui.fragment.settings.edit_profile


import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.annotation.StringRes
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ziggy.kdo.R
import com.ziggy.kdo.listener.CustomOnItemClickListener
import com.ziggy.kdo.ui.activity.camera.CONFIGURATION_PROFILE
import com.ziggy.kdo.ui.adapter.EditProfileAdapter


/**
 * A simple [Fragment] subclass.
 *
 */
class EditProfilFragment : Fragment(), CustomOnItemClickListener {

    private val PHOTO_PROFIL: Int = 0

    private val INFORMATION: Int = 1

    private val EMAIL: Int = 2

    private lateinit var recyclerView: RecyclerView

    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var editProfileAdapter: EditProfileAdapter

    private lateinit var viewEdit: View

    @StringRes
    private val EDIT_PHOTO = R.string.edit_profile_photo

    @StringRes
    private val EDIT_INFORMATION = R.string.edit_profile_information

    @StringRes
    private val EDIT_EMAIL = R.string.edit_profile_password


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewEdit = inflater.inflate(R.layout.fragment_edit_profil, container, false)

        val arrayEdit = listOf(
            getString(EDIT_PHOTO),
            getString(EDIT_INFORMATION),
            getString(EDIT_EMAIL)
        )

        val arrayImage = listOf(
            context?.getDrawable(R.drawable.ic_photo_profile)!!,
            context?.getDrawable(R.drawable.ic_edit_information)!!,
            context?.getDrawable(R.drawable.ic_mail_edit_profile)!!
        )

        recyclerView = viewEdit.findViewById(R.id.edit_profile_recyclerview)

        linearLayoutManager = LinearLayoutManager(activity)

        viewManager = linearLayoutManager

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            editProfileAdapter = EditProfileAdapter(arrayEdit, arrayImage, this@EditProfilFragment)
            viewAdapter = editProfileAdapter
            recyclerView.adapter = viewAdapter
        }


        return viewEdit
    }


    override fun <T> onItemClick(view: View?, position: Int?, url: String?, varObject: T?) {
        when (position) {
            PHOTO_PROFIL -> {
                val args = Bundle()
                args.putBoolean(CONFIGURATION_PROFILE, true)
                findNavController().navigate(
                    R.id.action_editProfilFragment_to_galleryActivity,
                    args
                )
            }
            INFORMATION -> {
                findNavController().navigate(
                    R.id.action_editProfilFragment_to_userInformationFragment)
            }
            EMAIL -> {

            }
        }
    }
}
